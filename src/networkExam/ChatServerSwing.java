package networkExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServerSwing {
    private static final int PORT = 12345;
    private static final int THREAD_POOL_SIZE = 10;

    private static final String SELF_TAG = "__SELF__";
    private static final String TIMESTAMP_TAG = "__TS__";
    private static final String NICKNAME_TAG = "__NN__";
    private static final String MSG_TAG = "__MSG__";
    private static final String SYSTEM_TAG = "__SYS__";

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static final Map<String, ClientHandler> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        System.out.println("채팅 서버가 포트 " + PORT + "에서 시작되었습니다.");

        try (
                ServerSocket serverSocket = new ServerSocket(PORT)
        ) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executor.submit(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            System.err.println("서버 오류: " + e.getMessage());
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;
        private PrintWriter out;
        private String nickname;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))
            ) {
                out = new PrintWriter(socket.getOutputStream(), true, StandardCharsets.UTF_8);

                String tmp;
                while (true) {
                    out.println("닉네임을 입력하세요: ");
                    tmp = in.readLine();

                    if (tmp == null) {
                        socket.close();
                        return;
                    }

                    tmp = tmp.trim();
                    if (tmp.isEmpty()) {
                        out.println("닉네임을 입력하지 않으셨습니다. 1개 이상의 글자를 입력 해 주세요.");
                        continue;
                    }

                    if (clients.containsKey(tmp)) {
                        out.println("이미 사용 중인 닉네임입니다. 다른 닉네임을 입력하세요.");
                        continue;
                    }

                    nickname = tmp;
                    clients.put(nickname, this);
                    break;
                }

                broadcastSystem(nickname + "님이 채팅방에 입장했습니다. [현재 인원: " + clients.size() + "명]");

                String message;
                while ((message = in.readLine()) != null) {
                    if ("bye".equalsIgnoreCase(message)) {
                        break;
                    }

                    broadcastChat(nickname, message, this);
                }

            } catch (IOException e) {
                System.err.println("클라이언트 처리 오류: " + e.getMessage());
            } finally {

                if (nickname != null) {
                    clients.remove(nickname);
                    broadcastSystem(nickname + "님이 채팅방을 나갔습니다. [현재 인원: " + clients.size() + "명]");
                }

                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("소켓 종료 오류: " + e.getMessage());
                }
            }
        }

        public void sendMessage(String message) {
            if (out != null) {
                out.println(message);
            }
        }

        private static void broadcastChat(String nickname, String plainMessage, ClientHandler sender) {
            String ts = LocalDateTime.now().format(TIME_FORMATTER);
            String tagged = TIMESTAMP_TAG + ts + NICKNAME_TAG + nickname + MSG_TAG + plainMessage;
            broadcastTagged(tagged, sender, true); // true => add SELF_TAG to sender only
        }

        private static void broadcastSystem(String plainMessage) {
            String ts = LocalDateTime.now().format(TIME_FORMATTER);
            String tagged = SYSTEM_TAG + TIMESTAMP_TAG + ts + MSG_TAG + plainMessage;
            broadcastTagged(tagged, null, false); // sender null, and no SELF tagging
        }
    }

    private static void broadcastTagged(String taggedMessage, ClientHandler sender, boolean addSelfTagForSender) {
        for (ClientHandler client : clients.values()) {
            if (addSelfTagForSender && client == sender) {
                client.sendMessage(SELF_TAG + taggedMessage);
            } else {
                client.sendMessage(taggedMessage);
            }
        }
    }
}
