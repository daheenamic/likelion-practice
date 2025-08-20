package day02;

public class OpExam {
    public static void main(String[] args) {
        int a = 10;
        int b = 3; // 대입연산자

        System.out.println("더하기: " + (a + b));
        System.out.println("빼기: " + (a - b));
        System.out.println("곱하기: " + (a * b));
        System.out.println("나누기: " + (a / b));
        System.out.println("나머지: " + (a % b));

        boolean ba = true, bb = false;

        // and && 두 조건이 모두 참 일때만 참
        // or || 두 조건중에 하나라도 참이면 참
        System.out.println(ba && bb); // false
        System.out.println(ba || bb); // true
        System.out.println(!ba); // false
        System.out.println(ba ^ bb); // true

        // a = 10, b = 3
        int c = 5;
        int d = 8;

        System.out.println("===============================");
        System.out.println((a > b++) && (c < d++)); // true
        System.out.println("b: " + b); // 4
        System.out.println("d: " + d); // 9

        System.out.println("===============================");
        System.out.println((a < b++) && (c > d++)); // false
        System.out.println("b: " + b); // 5
        System.out.println("d: " + d); // 9 - 첫번째 조건이 false 라서 두번째가 실행되지 않음

        // 증감연산자
        a++; // a = a+1;
        System.out.println("a: " + a);

        int incrI = 10;
        System.out.println("===============================");
        System.out.println(++incrI); // 11: 증가하고 출력

        incrI = 10; // 10으로 초기화
        System.out.println(incrI++); // 10: 출력먼저하고
        System.out.println(incrI); // 11: 증가
    }
}
