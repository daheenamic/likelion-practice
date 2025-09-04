package day12;

import java.util.Scanner;

// Scanner도 내부적으로 IO를 쓴다. 사용자로부터 쓰기 편하게 제공하는 객체
// 그래서 io가 아닌 util 패키지에 분류하고 있다.
// Scanner에는 매개변수로 InputStream 타입이 들어올 수 있으므로, 그 타입을 상속받는 자식들도 모두 들어올 수 있음 !!
public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("정수를 입력하세요: ");
            int intValue = scanner.nextInt();

            System.out.print("실수를 입력하세요: ");
            double doubleValue = scanner.nextDouble();

            System.out.print("true/false를 입력하세요: ");
            boolean boolValue = scanner.nextBoolean();

            // 버퍼 비우기 (nextLine() 전에 필요) TODO: 무슨 말인지 자세히 찾아보기 (Enter값까지 형변환 시킬 수 없어서 ?)
            scanner.nextLine();

            System.out.print("문자열을 입력하세요: ");
            String stringValue = scanner.nextLine();

            System.out.println("\n=== 입력 결과 ===");
            System.out.println("정수: " + intValue);
            System.out.println("실수: " + doubleValue);
            System.out.println("불린: " + boolValue);
            System.out.println("문자열: " + stringValue);

        } finally {
            scanner.close();
        }
    }
}