package lambdaExam;

import java.util.*;
import java.util.function.*;

/**
 * 람다식 입문 10문제 (Stream 사용 X)
 * 각 번호별로 주석을 읽고 TODO를 직접 채워보세요.
 */
public class LambdaPractice {
    // 10번 문제의 인터페이스 정의
    // - 어노테이션: @FunctionalInterface
    // - 인터페이스명: MyCalc
    // - 메서드명: calc

    public static void main(String[] args) {
        System.out.println("=== Lambda Practice ===");

        // ------------------------------------------------------------
        // 1) 숫자 그대로 반환
        //    - 입력된 정수를 그대로 반환하는 람다식을 작성하세요.
        //    - 타입: Function<Integer, Integer>
        //    - 기대: f.apply(7) == 7
        // TODO: Function<Integer, Integer> f = ???

        // System.out.println("[1] " + f.apply(7));

        // ------------------------------------------------------------
        // 2) 숫자 제곱하기
        //    - 입력 정수의 제곱을 반환하는 람다식.
        //    - 타입: Function<Integer, Integer>
        //    - 기대: 5 -> 25
        // TODO: Function<Integer, Integer> square = ???

        // System.out.println("[2] " + square.apply(5));

        // ------------------------------------------------------------
        // 3) 두 수 더하기
        //    - 두 정수를 더해서 반환.
        //    - 타입: IntBinaryOperator (int,int->int)
        //    - 기대: (2,9) -> 11
        // TODO: IntBinaryOperator add = ???

        // System.out.println("[3] " + add.applyAsInt(2, 9));

        // ------------------------------------------------------------
        // 4) 두 수 중 큰 값 반환
        //    - 타입: IntBinaryOperator
        //    - 기대: (10,3) -> 10
        // TODO: IntBinaryOperator max = ???

        // System.out.println("[4] " + max.applyAsInt(10, 3));

        // ------------------------------------------------------------
        // 5) 문자열 길이 구하기
        //    - 문자열의 length를 반환.
        //    - 타입: Function<String, Integer>
        //    - 기대: "lambda" -> 6
        // TODO: Function<String, Integer> length = ???

        // System.out.println("[5] " + length.apply("lambda"));

        // ------------------------------------------------------------
        // 6) 문자열을 대문자로 변환
        //    - 타입: Function<String, String>
        //    - 기대: "java" -> "JAVA"
        // TODO: Function<String, String> toUpper = ???

        // System.out.println("[6] " + toUpper.apply("java"));

        // ------------------------------------------------------------
        // 7) Runnable로 출력하기
        //    - 파라미터/반환값 없는 람다: Runnable
        //    - 기대: "Hello Lambda!" 출력
        // TODO: Runnable r = ???

        System.out.print("[7] ");
        // r.run();

        // ------------------------------------------------------------
        // 8) 문자열 배열 정렬 (알파벳순)
        //    - Arrays.sort(T[], Comparator<? super T>)에 람다 전달
        //    - 힌트: compareTo()
        //    - 기대: [apple, banana, cherry]
        String[] arr1 = {"banana", "apple", "cherry"};
        // TODO: Arrays.sort(arr1, ???);

        System.out.println("[8] " + Arrays.toString(arr1));

        // ------------------------------------------------------------
        // 9) 문자열 배열 정렬 (길이순)
        //    - 길이가 짧은 문자열이 먼저 오도록 정렬
        //    - 힌트: Integer.compare(a.length(), b.length())
        //    - 기대: [kiwi, apple, strawberry]
        String[] arr2 = {"kiwi", "strawberry", "apple"};
        // TODO: Arrays.sort(arr2, ???);

        System.out.println("[9] " + Arrays.toString(arr2));

        // ------------------------------------------------------------
        // 10) 직접 만든 함수형 인터페이스 사용하기
        //    - 두 수를 곱해 반환하는 람다 작성
        //    - 기대: (3,4) -> 12
        // TODO: MyCalc mul = ???

        //System.out.println("[10] " + mul.calc(3, 4));
    }
}
