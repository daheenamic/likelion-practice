package streamExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExam01 {
    public static void main(String[] args) {
        int[] iarr = {1, 2, 4, 5, 6, 7, 8, 0};

        // 짝수만 출력 - 스트림 없이
        for (int i : iarr) {
            if(i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        // 스트림 이용해서
        Arrays.stream(iarr)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::print);

        System.out.println();
        System.out.println("=".repeat(20));

        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");
        // words에서 글자수 5개 이상인 것만 필터링하고 중복을 제거해서 새로운 리스트를 얻기
        // 리스트.contains(단어) -- 리스트에 단어가 있다면 true 리턴

        // 스트림을 사용하지 않기
        List<String> resultWords = new ArrayList<>();
        for (String word : words) {
            if(word.length() >= 5) {
                if(resultWords.contains(word)) continue;
                resultWords.add(word);
            }
        }

        // 스트림을 쓰기
        List<String> resultWords2 = words.stream()
                .filter(w -> w.length() >= 5)
                .distinct()
                .toList(); // 불변리스트

        System.out.println(resultWords2); // [Apple, Banana, Cherry]
//        resultWords2.add("Test"); // 에러

        List<String> resultWords3 = words.stream()
                .filter(w -> w.length() >= 5)
                .distinct()
                .collect(Collectors.toList()); // 가변 리스트

        resultWords3.add("Test");
        System.out.println(resultWords3); // [Apple, Banana, Cherry, Test]


    }
}
