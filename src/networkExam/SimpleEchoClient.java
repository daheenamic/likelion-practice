package networkExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleEchoClient {
    private static final String SERVER_HOST = "15.164.228.241";
    private static final int SERVER_PORT = 8010;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // 클라이언트는 키보드로부터 입력 받아서 입력 받아서 서버에 전송해야 한다.
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("서버에 연결되었습니다.");
            System.out.println("서버에 전달할 메세지를 입력하세요. bye를 입력 시 종료됩니다.");

            // 메세지를 여러번 보내야 하기 때문에 반복문 사용
            while (true) {
                // 사용자가 키보드로부터 입력할 내용
                String message = scanner.nextLine();
                // 사용자가 입력한 내용을 서버에 전송
                out.println(message); // out - 소켓

                // 서버가 응답한 내용을 읽어옴
                String response = in.readLine();

                // [안정성] 서버가 연결을 먼저 끊었을 경우를 확인합니다.
                if (response == null) {
                    System.out.println("서버와의 연결이 끊어졌습니다.");
                    break;
                }

                // 서버가 보낸 메세지를 내 콘솔에 출력
                System.out.println("서버 응답: " + response);

                // [가독성] "bye"를 보낸 후에 루프를 종료합니다.
                if ("bye".equalsIgnoreCase(message)) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("클라이언트를 종료합니다.");
    }
}
