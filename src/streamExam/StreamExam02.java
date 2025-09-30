package streamExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExam02 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");

        // 소문자로 바꿔서 출력
        words.stream().distinct().map(String::toLowerCase).forEach(w -> System.out.print(w + " "));

        System.out.println();
        System.out.println("=".repeat(20));

        // 대문자로 바꿔서 출력
        words.stream().distinct().map(String::toUpperCase).forEach(w -> System.out.print(w + " "));

        System.out.println();
        System.out.println("=".repeat(20));

        int[] intArr = {200, 3, 4, 7, 88, 99};

        // (1) 3씩 더해서 배열로 만든 후 출력
        List<Integer> intArr2 = Arrays.stream(intArr)
                        .map(n -> n + 3)
                .boxed()
                .toList();

        System.out.println(intArr2); // [203, 6, 7, 10, 91, 102]
    }
}
