package day04;

public class VarArgsExample {
    // 객체 - 속성(값, 필드), 행위(기능, 메서드)
    // 접근제한자 리턴타입 메서드명 (매개변수들...)
    // 정수 2개를 받아서 정수 두개를 더해서 더한값을 리턴하는 add라는 이름의 메서드를 정의해 보자
    // 누구든지 사용할 수 있도록 접근 제한자를 정한다.
    public static int add(int a, int b, int c) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static int total(int... numbers) {

        int total = 0;

        // 컴파일러에서 내부적으로 numbers를 배열 처리 해 줌
        for(int num : numbers) {
            total += num;
        }

        return total;
    }

    // main - 프로그램의 시작점
    public static void main(String[] args) {

        System.out.println(add(1,2, 3));
        System.out.println(minus(3,2));

        System.out.println(total(1,2,3,4,5));
    }
}
