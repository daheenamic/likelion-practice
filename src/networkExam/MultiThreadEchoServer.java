package networkExam;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class MultiThreadEchoServer {
    private static final int PORT = 12345;
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        // 서버 소켓 생성
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("멀티스레드 에코 서버가 포트 " + PORT + "에서 시작되었습니다.");

            while (true) {
                // 클라이언트부터 소켓을 얻어옴
                Socket clientSocket = serverSocket.accept();
                // 클라이언트별로 각각 통신할 수 있는 스레드가 필요하다.
                executor.submit(new ClientHandler(clientSocket));

                // 스레드풀이 없다면 아래와 같이 스레드를 생성해서 직접 스레드를 시작해야 한다.
                // Thread t = new Thread(new ClientHandler(clientSocket));
                // t.start(); // 직접 스레드 시작
            }
        } catch (IOException e) {
            System.err.println("서버 오류: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    // Runnable을 implements해서 클라이언트 핸들러를 구현
    static class ClientHandler implements Runnable {
        // 각각의 스레드에 각각 연결될 소켓이 필요하기때문에 소켓을 생성한다.
        private final Socket clientSocket;

        // 생성자
        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(
                         clientSocket.getOutputStream(), true)) {

                String clientAddress = clientSocket.getRemoteSocketAddress().toString();
                System.out.println("클라이언트 연결됨: " + clientAddress);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(clientAddress + "로부터: " + inputLine);
                    out.println("Echo: " + inputLine);

                    if ("bye".equalsIgnoreCase(inputLine)) {
                        break;
                    }
                }

                System.out.println("클라이언트 연결 종료: " + clientAddress);

            } catch (IOException e) {
                System.err.println("클라이언트 처리 오류: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("소켓 종료 오류: " + e.getMessage());
                }
            }
        }
    }
}
