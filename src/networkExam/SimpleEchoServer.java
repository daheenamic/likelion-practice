package networkExam;

import java.io.*;
import java.net.*;

// TCP Echo 서버 구현
// 클라이언트가 서버에 메시지를 보내면 서버가 동일한 메시지를 클라이언트에게 되돌려주는 간단한 네트워크 애플리케이션이다.
public class SimpleEchoServer {
    public static void main(String[] args) {

        // 1. 서버 소켓 열기 -- 반드시 닫아줘야함
        try (ServerSocket serverSocket = new ServerSocket(12345)){
            System.out.println("Echo Server가 12345 port에서 시작되었습니다.");

            while (true) {
                // 서버가 클라이언트를 기다리다가 (accept()) 클라이언트가 해당 서버에 접속하면 소켓이 return 된다.
                try (Socket socket = serverSocket.accept();
                    // 클라이언트 소켓을 이용해서 클라이언트와의 연결 통료를 얻을 수 있다.
                    // 클라이언트와 서버 사이에 입출력이 일어나는데 항상 입출력은 하나의 통로에서 동작할 수 없다. -- 각각 통로가 필요
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    // autoFlush: true -> 버퍼가 차면 자동으로 내보내주게끔 설정
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    System.out.println("클라이언트 연결: " + socket.getRemoteSocketAddress());

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("클라이언트로 부터 받은 메세지: " + inputLine);
                        out.println("Echo: " + inputLine);

                        if("bye".equalsIgnoreCase(inputLine)) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (Exception e) {
            System.out.println("서버 시작 실패: " + e.getMessage());
        }
    }
}

