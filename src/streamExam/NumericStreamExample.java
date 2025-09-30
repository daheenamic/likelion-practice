package streamExam;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class NumericStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // IntStream으로 변환하여 집계
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("합계: " + sum); // 15

        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("평균: " + average); // 3.0

        // 통계 정보 한 번에 얻기
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println("통계: " + stats);
        // IntSummaryStatistics{count=5, sum=15, min=1, average=3.0, max=5}
    }
}
