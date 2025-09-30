package streamExam;

import java.util.*;
import java.util.stream.*;

public class StreamCreation {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Python", "JavaScript");

        // 원본 데이터
        System.out.println(list); // [Java, Python, JavaScript]

        // 1. Stream 전: 전체 출력(for)
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)); // Java Python JavaScript
        }

        // 2. Stream 전: 필터링(for + if)
        for (String s : list) {
            if (s.startsWith("J")) {
                System.out.println(s); // Java JavaScript
            }
        }

        // 3. Stream: 생성 -> 전체 출력(forEach)
        list.stream()
                .forEach(System.out::println); // Java Python JavaScript

        // 4. Stream: 필터링(filter) -> forEach
        list.stream()
                .filter(s -> s.startsWith("J"))
                .forEach(System.out::println); // Java JavaScript

        // 5. Stream: 변환(map) -> forEach
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println); // JAVA PYTHON JAVASCRIPT

        // 6. Stream 재사용 불가: 새 스트림 생성해서 사용
        Stream<String> s1 = list.stream();
        s1.forEach(System.out::println); // 첫 소비
        // s1.forEach(System.out::println); // 재사용 불가 (IllegalStateException)
        list.stream().filter(x -> x.length() > 4).forEach(System.out::println); // 새 스트림으로 재사용 패턴

    }
}
