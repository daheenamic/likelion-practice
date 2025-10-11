package networkExam;

import java.net.*;
import java.util.Scanner;

public class UDPEchoClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 9876;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try (
                DatagramSocket socket = new DatagramSocket();
                Scanner scanner = new Scanner(System.in)
        ) {
            InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);
            byte[] buffer = new byte[BUFFER_SIZE];

            System.out.println("UDP Echo 클라이언트");
            System.out.println("메시지를 입력하세요 (quit: 종료):");

            while (true) {
                System.out.print("> ");
                String message = scanner.nextLine();

                if ("quit".equalsIgnoreCase(message)) {
                    break;
                }

                // 데이터 전송
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData,
                        sendData.length,
                        serverAddress,
                        SERVER_PORT
                );
                socket.send(sendPacket);

                // 응답 수신
                DatagramPacket receivePacket =
                        new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                String response = new String(
                        receivePacket.getData(),
                        0,
                        receivePacket.getLength()
                );
                System.out.println("서버: " + response);
            }

        } catch (Exception e) {
            System.err.println("클라이언트 오류: " + e.getMessage());
        }
    }
}
