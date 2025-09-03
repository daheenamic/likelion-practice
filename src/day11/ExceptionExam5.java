package day11;

import java.io.FileReader;

public class ExceptionExam5 {
    // 예외를 처리하는 2가지 방법
    public static void errand() {
        int i = 0; // i의 값이 무엇이 들어올지 모름

        try {
            // 두부를 사는 로직이라고 가정
            System.out.println("두부를 사러 가는 중..");
            System.out.println(10/i);
        } catch (Exception e) {
            // 두부가 없다면?
            System.out.println("두부가 없는 예외가 발생해 다른 마트로 감.");
        }

    }

    // 예외를 심부름 시킨쪽으로 알려줌
    public static void errand2() throws RuntimeException{
        // throws : 넘기고 싶은 예외
        int i = 0;
        System.out.println(10/i);
    }

    public static void main(String[] args) {
        errand();

        // 예외의 종류
        // 1. 반드시 처리해야만 하는 예외 - checked Exception 처리를 안하면 컴파일부터 안된다.
        // 2. 처리하지 않아도 컴파일 에러는 발생하지 않음 - unChecked Exception

        errand2();
        // errand2()메서드를 Exception을 던지면 컴파일 에러가 발생 : Unhandled exception: java.lang.Exception
        // RuntimeException를 던지면 예외는 발생하지만 컴파일 에러는 발생하지 않음.
        // RuntimeException은 unChecked Exception을 상속받음

        String str = null;
        str.charAt(0);

//        FileReader fr = new FileReader("a"); // Unhandled exception: java.io.FileNotFoundException

    }
}
