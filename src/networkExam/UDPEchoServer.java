package networkExam;

import java.net.*;

/**
 * 간단한 UDP Echo 서버
 * 클라이언트로부터 메시지를 수신하면 "Echo:" 접두사를 붙여 다시 클라이언트로 응답을 보내는 서버
 */
public class UDPEchoServer {
    private static final int PORT = 9876;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try (
                // UDP 전용 소켓 클래스
                DatagramSocket socket = new DatagramSocket(PORT)
        ) {
            System.out.println("UDP Echo 서버 시작 (포트: " + PORT + ")");

            byte[] buffer = new byte[BUFFER_SIZE];

            while (true) {
                // 클라이언트로부터 데이터를 받을 패킷 생성 (버퍼 크기만큼 공간 확보)
                DatagramPacket receivePacket =
                        new DatagramPacket(buffer, buffer.length);
                // 실제 데이터 수신 (이 메서드는 블로킹됨 → 데이터 올 때까지 대기)
                socket.receive(receivePacket);

                // 수신된 바이트 데이터를 문자열로 변환 (패킷 길이만큼만 사용)
                String received = new String(
                        receivePacket.getData(),
                        0,
                        receivePacket.getLength()
                );
                System.out.println("받은 메시지: " + received);

                // 수신한 패킷에서 클라이언트의 IP 주소와 포트 번호 추출
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Echo 응답 메시지 생성 ("Echo:" 접두사 붙임)
                String response = "Echo: " + received;
                byte[] responseData = response.getBytes();

                // 응답 데이터를 담은 패킷 생성 (클라이언트 주소 및 포트 포함)
                DatagramPacket sendPacket = new DatagramPacket(
                        responseData,
                        responseData.length,
                        clientAddress,
                        clientPort
                );

                // 클라이언트로 Echo 응답 전송
                socket.send(sendPacket);
                System.out.println("응답 전송: " + response);

                // 무한 루프를 돌며 계속해서 클라이언트 요청 처리
            }

        } catch (Exception e) {
            System.err.println("서버 오류: " + e.getMessage());
        }
    }
}
