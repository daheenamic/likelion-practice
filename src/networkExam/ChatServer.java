package networkExam; // 패키지: 소스가 속한 네임스페이스

import java.io.*;                // 입출력 스트림(BufferedReader, PrintWriter 등)
import java.net.*;               // 네트워크 소켓(ServerSocket, Socket 등)
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;   // 동시성 도구(ConcurrentHashMap 등)

/**
 * ChatServer
 * - 여러 클라이언트가 동시에 접속해 1:N으로 메시지를 주고받는 콘솔 채팅 서버
 * - 핵심 포인트: (1) 클라이언트별 핸들러 스레드 (2) 공유 Set로 전체 클라이언트 관리 (3) broadcast로 전송
 */
public class ChatServer {
    // [상수] 시각 포맷: 14:23:59 형태로 찍기
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    // [상수] 서버가 바인딩할 포트 번호 (클라이언트가 여기에 접속, 서버는 이 포트에서 대기(listen))
    // listen - 서버소켓이 클라이언트 연결 요청을 받을 준비가 되어 대기하는 상태
    private static final int PORT = 12345;
    private static final int THREAD_POOL_SIZE = 10;

    // [공유 상태] 접속 중인 모든 클라이언트 핸들러를 담는 Set
    // - ConcurrentHashMap.newKeySet(): 스레드 안전한 Set 구현 - 모든 접속자(각 ClientHandler)를 여기에 보관
    // - static이라서 모든 핸들러 인스턴스가 같은 Set을 공유해야 하므로 정적 필드 (브로드캐스트 대상)
    private static final Set<ClientHandler> clients = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        System.out.println("채팅 서버가 포트 " + PORT + "에서 시작되었습니다.");

        // try-with-resources: 서버 소켓을 안전하게 열고 종료 보장
        try (
                // 12345 포트에서 TCP 연결을 받겠다고 등록 -> 12345 포트에서 TCP 연결을 받을 준비가 되어 있다.
                ServerSocket serverSocket = new ServerSocket(PORT)
        ) {
            while (true) { // 서버는 일반적으로 무한루프에서 연결을 계속 수락
                // [수락] 클라이언트가 접속하면 새로운 Socket이 반환됨(클라이언트 전용 통신 채널)
                // accept()는 대기 큐에서 실제 연결을 뽑아옴
                Socket clientSocket = serverSocket.accept();

                // [핸들러 준비] 각 클라이언트를 담당할 Runnable 생성 - 연결 하나당 작업단위 생성
                ClientHandler clientHandler = new ClientHandler(clientSocket);

                // [공유 목록 등록] 전역 Set에 먼저 등록해 두면 이후 broadcast 시 대상에 포함됨
                //  - 주의: 아직 out이 세팅되기 전이지만, sendMessage는 out null 체크를 하므로 NPE 방지됨
                clients.add(clientHandler);

                // [동시성] 각 클라이언트를 독립 스레드로 처리 → 동시에 여러 사람 대화 가능
                // new Thread(clientHandler).start(); -> 스레드풀로 제한
                executor.submit(clientHandler);
            }
        } catch (IOException e) {
            System.err.println("서버 오류: " + e.getMessage());
        }
    }

    /** 클라이언트 1명을 담당하는 작업 단위(Runnable) */
    static class ClientHandler implements Runnable {
        private final Socket socket; // 이 핸들러가 담당하는 클라이언트 소켓
        private PrintWriter out;     // 이 클라이언트에게 보낼 출력 스트림(자동 flush)
        private String nickname;     // 닉네임(첫 줄로 입력받음)

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // 입력 스트림(클라이언트 → 서버). try-with-resources로 자동 close
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                // 출력 스트림(서버 → 클라이언트). autoFlush=true로 println 시 즉시 전송
                out = new PrintWriter(socket.getOutputStream(), true);

                // [1] 닉네임 요청/설정
                out.println("닉네임을 입력하세요: "); // 클라이언트에 프롬프트 전송(개행 필수)
                nickname = in.readLine();        // 클라이언트가 보낸 닉네임 한 줄 수신
                if (nickname == null || nickname.trim().isEmpty()) {
                    return; // 닉네임이 없으면 세션 종료
                }

                // 서버 콘솔 로그 + 다른 참여자에게 공지(입장)
                System.out.println(nickname + "님이 채팅방에 입장했습니다. [현재 인원: " + clients.size() + "명]");
                broadcast(nickname + "님이 채팅방에 입장했습니다. [현재 인원: " + clients.size() + "명]", this);

                // [2] 채팅 루프: 클라이언트가 보낸 각 줄을 받아 전체에 방송
                String message;
                while ((message = in.readLine()) != null) { // 클라이언트가 연결을 끊으면 null
                    if ("bye".equalsIgnoreCase(message)) {
                        break; // 사용자가 bye 입력 시 종료
                    }
                    // [타임스탬프 포맷] [HH:mm:ss] nickname: message
                    String timestamp = LocalDateTime.now().format(TIME_FORMATTER);
                    System.out.println("[" + timestamp + "] " + nickname + ": " + message);  // 추가
                    broadcast("[" + timestamp + "] " + nickname + ": " + message, this);
                }

            } catch (IOException e) {
                System.err.println("클라이언트 처리 오류: " + e.getMessage());
            } finally { // 연결 종료/예외 시 정리
                // [공유 목록 제거] 더 이상 방송 대상이 아님
                clients.remove(this);

                if (nickname != null) {
                    System.out.println(nickname + "님이 채팅방을 나갔습니다. [현재 인원: " + clients.size() + "명]");
                    broadcast(nickname + "님이 채팅방을 나갔습니다. [현재 인원: " + clients.size() + "명]", this);
                }

                // 소켓 종료(입출력 스트림은 try-with-resources로 정리됨)
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("소켓 종료 오류: " + e.getMessage());
                }
            }
        }

        /** 서버 → 이 클라이언트 하나에게 메시지 전송 */
        public void sendMessage(String message) {
            if (out != null) { // out 초기화 이전에 호출될 수 있으므로 방어적 체크
                out.println(message); // println: 개행 포함 → 상대방 readLine()이 즉시 반환
            }
        }
    }

    /**
     * 모든 클라이언트에게 메시지를 전송하는 브로드캐스트 함수
     * @param message 보낼 내용(개행 없이 한 줄)
     * @param sender  보낸 사람 핸들러(자기 자신 제외하려면 비교에 사용)
     */
    private static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            // 현재 구현: 보낸 사람도 포함해 전송 (내가 쓴 메세지도 볼 수 있음)
            // 보낸 사람 제외를 원하면 아래 조건을 해제:
            // if (client != sender) { client.sendMessage(message); }
            client.sendMessage(message);
        }
    }
}
