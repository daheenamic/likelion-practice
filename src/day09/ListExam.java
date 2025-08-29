package day09;

import java.util.ArrayList;
import java.util.List;

public class ListExam {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<>();

        // 인터페이스 타입으로 선언해서 구현을 한다면 다른 타입의 리스트를 쓰고 싶을 때 쉽게 바꿔 쓸 수 있다.
        // fruits = new LinkedList<>(); 사용가능
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Strawberry");

        System.out.println(fruits.get(0));
        fruits.set(1, "Cherry");

        // 출력 결과가 [Apple, Cherry, Strawberry] 라고 나오는 이유는 toString()을 오버라이드 했다는 것을 알 수 있다.
        // 객체 자체가 출력된 것이 아니라 요소의 내용만 출력 되는 것이다.
        System.out.println(fruits);

        System.out.println(fruits.remove("Cherry")); // true
        System.out.println(fruits); // [Apple, Strawberry]
        System.out.println(fruits.remove(0)); // Apple
        System.out.println(fruits); // [Strawberry]

        fruits.add("Strawberry");
        fruits.add("Strawberry");
        fruits.add("Strawberry");
        System.out.println(fruits); // [Strawberry, Strawberry, Strawberry, Strawberry] 중복허용

    }
}
