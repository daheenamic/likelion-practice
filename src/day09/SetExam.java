package day09;

import java.io.FilterOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExam {
    public static void main(String[] args) {
        Set<String> fruitSet = new HashSet<>();

        // 데이터 추가
        fruitSet.add("Apple");
        fruitSet.add("Orange");
        fruitSet.add("Grape");

        System.out.println(fruitSet); // [Apple, Grape, Orange]

//        fruitSet.get(0); // 순서를 보장하지 않기 때문에 인덱스로 꺼낼 수 없음.

        fruitSet.add("Apple");
        fruitSet.add("Apple");
        fruitSet.add("Apple");
        fruitSet.add("Apple");

        System.out.println(fruitSet); // [Apple, Grape, Orange] 중복 허용 안함

        System.out.println("=========================");

        Set<Pen> penSet = new HashSet<>();
        penSet.add(new Pen("red"));
        penSet.add(new Pen("black"));
        penSet.add(new Pen("blue"));

        System.out.println(penSet); // 주소값이 출력

        // toString을 오버라이드 하면 String을 출력
        System.out.println(penSet);

        // equals(), hashCode()를 오버라이드 전
        penSet.add(new Pen("blue"));
        System.out.println(penSet); // 객체가 달라서 blue가 두번 출력 됨

        // equals()랑 hashCode()를 오버라이드 후
        System.out.println(penSet); // blue 중복 제거 됨

        // set은 순서가 중요하지 않아서 index를 갖고있지 않음.
        // 그래서 Iterator을 이용 할 수 있음.
        Iterator<String> iterator = fruitSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 똑같이 foreach로 접근 가능
        System.out.println("======================");
        for (String str : fruitSet) {
            System.out.println(str);
        }

        System.out.println(fruitSet.contains("Apple")); // true
        System.out.println(fruitSet.remove("Apple")); // true
        System.out.println(fruitSet); // [Grape, Orange] - Apple이 제거됨
        System.out.println(fruitSet.size()); // 2
    }
}
