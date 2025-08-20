package day02;

public class VariableTest {
    int intValue; // 클래스변수
    public static void main(String[] args) {

        // 변수 선언
        // 타입 변수명;
        // int는 타입, i는 변수명, 1은 리터럴 -> 1이라는 값을 int타입의 i라는 변수에 넣어준 것
        int i = 1; // 지역변수

        // 자바 - 강형 언어.
        // 변수의 타입이 정해지는 언어
        // 밥상 - 어떤 똑같은 그릇에다가 음식을 담나요?
        // 어떤 언어는 그릇의 종류에 상관없이 아무거나 담는 언어 - 약형 언어

        // 자바의 기본 타입

        int x; // 변수가 선언 되면
        x = 0; // 초기화를 반드시 시켜줘야 한다.
        x = 10;

        System.out.println(x + i);

        // 자바의 타입 - 기본타입, 레퍼런스 타입
        // 기본타입 - 값이 들어감
        // 레퍼런스타입 - 주소값이 들어감
        // 자바 프로그램의 대다수는 래퍼런스 타입
        // 기본 타입 - 8개만 존재 / 숫자(정수,실수), 문자, boolean
        byte b = 'a';
        System.out.println(b); // 97

    }
}
