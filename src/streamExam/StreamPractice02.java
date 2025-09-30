package streamExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamPractice02 {
    public static void main(String[] args) {
        // 1. 주어진 List<String>을 문자열 길이에 따라 오름차순으로 정렬하되,
        // 람다식을 사용하여 Collections.sort() 메서드를 활용하라.
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grape", "strawberry");

        Collections.sort(words, (a, b) -> a.length() - b.length()); // Collections은 옛날방식이어서
        words.sort((a, b) -> a.length() - b.length()); // IDE가 List 자체의 sort를 권장
        words.sort(Comparator.comparingInt(String::length)); // 더 권장되는 방식

        System.out.println("1. List를 오름차순으로 정렬: " + words);
        System.out.println("=".repeat(20));

        // 2. 주어진 정수 배열에서 최대값을 찾아 출력하라.
        // 람다식을 사용하여 자바의 Comparator 인터페이스와 함께 Arrays.stream()과 max() 메서드를 활용하라.
        int[] numbers = {23, 45, 12, 67, 34, 89, 56};

        int max = Arrays.stream(numbers)
                .boxed()
                .max(Comparator.comparingInt(Integer::intValue))
                .orElseThrow();

//        max = Arrays.stream(numbers).max().orElseThrow(); // 간단한 방법
        System.out.println("2. 최대값: " + max);
        System.out.println("=".repeat(20));

        // 3. 주어진 List<Integer>의 각 요소에 10을 더한 결과를 새 리스트에 저장하고 출력하라.
        // 스트림의 map() 메서드와 람다식을 활용하라.
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);

        // 4. 주어진 List<String>에서 글자 수가 5 이상인 첫 번째 단어를 찾아 출력하라.
        // 스트림의 filter()와 findFirst() 메서드를 활용하라.
        List<String> words2 = Arrays.asList("cat", "dog", "elephant", "bird", "giraffe");

        // 5. 주어진 List<Integer>의 각 요소를 제곱한 결과를 새 리스트에 저장하고 출력하라.
        // 스트림의 map() 메서드와 람다식을 활용하라.
        List<Integer> numbers3 = Arrays.asList(2, 3, 4, 5);

        // 6. 주어진 List<Integer>의 모든 요소가 짝수인지 확인하라.
        // 스트림의 allMatch() 메서드와 람다식을 활용하여 조건 검사를 수행하고 결과를 출력하라.
        List<Integer> numbers4 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> numbers5 = Arrays.asList(2, 4, 5, 8, 10);

        // 7. 주어진 List<String>에서 길이가 4 이상인 문자열만 필터링하고, 대문자로 변환한 후, 알파벳 순으로 정렬하여 출력하라.
        List<String> fruits = Arrays.asList("apple", "kiwi", "banana", "fig", "grape", "mango");
    }
}
