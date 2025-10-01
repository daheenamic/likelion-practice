package networkExam;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("www.google.com");
        System.out.println("ip::" + address.getHostAddress()); // ip::142.250.207.100
        System.out.println("host::" + address.getHostName()); // host::www.google.com

        System.out.println("=".repeat(20));

        boolean reachable = address.isReachable(3000);
        System.out.println("도달가능여부::" + reachable); // 도달가능여부::false -> 방화벽

        System.out.println("=".repeat(20));

        InetAddress[] allAddress = InetAddress.getAllByName("www.google.com");
        for (InetAddress addr : allAddress) {
            System.out.println("ip::" + addr.getHostAddress());
            // ip::142.250.207.100
            // ip::2404:6800:400a:804:0:0:0:2004
        }

        System.out.println("=".repeat(20));

        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("ip::" + localhost.getHostAddress()); // ip::127.0.0.1
        System.out.println("host::" + localhost.getHostName()); // host::Dahees-MacBook-Pro.local

        System.out.println("=".repeat(20));

        // byte 배열로 IP 주소 얻기
        byte[] ipAddr = localhost.getAddress();
        System.out.print("IP 주소 (byte): ");
        for (int i = 0; i < ipAddr.length; i++) {
            System.out.print((ipAddr[i] & 0xFF)); // 부호 없는 정수로 변환
            if (i < ipAddr.length - 1) {
                System.out.print(".");
            }
        }
    }
}
