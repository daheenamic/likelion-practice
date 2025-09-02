package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam10 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        Collections.shuffle(numbers);
        System.out.println(numbers);

        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println(numbers);




    }
}
