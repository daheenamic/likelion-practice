package day05;

import java.util.Scanner;

public class Calculator {
    // 게산기
    int num;
    String cal;

    public static double Result (int a, int b, String oper) {
        switch (oper) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return (double) a / b;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        int firstNum;
        int secondNum;
        String operator;

        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번재 숫자를 입력 해 주세요: ");
        firstNum = sc.nextInt();

        System.out.print("연산자를 입력 해 주세요(+, -, *, /): ");
        operator = sc.next();

        System.out.print("두 번째 숫자를 입력 해 주세요: ");
        secondNum = sc.nextInt();

        double result = Result(firstNum, secondNum, operator);

        if (operator.equals("/")) {
            System.out.printf("결과: %d %s %d = %.2f%n", firstNum, operator, secondNum, result);
        } else {
            System.out.printf("결과: %d %s %d = %d%n", firstNum, operator, secondNum, (int) result);
        }
    }
}
