package lambdaExam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class StandardFunctionalInterfaces {
    public static void main(String[] args) {
        // Predicate<T> - 매개변수 하나, boolean 반환
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4)); // true
        System.out.println(isEven.test(5)); // false

        // Function<T, R> - 매개변수 하나, 다른 타입 반환
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println(stringLength.apply("Hello")); // 5

        // Consumer<T> - 매개변수 하나, 반환값 없음 (void)
        Consumer<String> printer = str -> System.out.println("출력: " + str);
        printer.accept("람다식 테스트"); // 출력: 람다식 테스트

        // Supplier<T> - 매개변수 없음, 값 반환
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("랜덤 값: " + randomSupplier.get());

        // BinaryOperator<T> - 같은 타입 매개변수 두 개, 같은 타입 반환
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 20)); // 30
    }
}
