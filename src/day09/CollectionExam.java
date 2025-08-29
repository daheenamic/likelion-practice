package day09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionExam {
    public static void main(String[] args) {
        // 가장 많이 사용되는 자료구조
        // 저장될 때 Object가 저장됨 - 모든 객체가 저장된다.
        ArrayList list = new ArrayList();
        list.add("123");
        list.add(11);

        // 모든 객체를 다 넣을 수 있을때의 단점
        list.get(0);

        ArrayList list2 = new ArrayList();
        list2.add("abc");
        list2.add("def");

        // String이 제공하는 메서드를 바로 사용할 수 없다.
        // 부모타입(Object)일 때 자식의 메서드(String)에 접근이 되지 않는다. -> 형변환 필요
        ((String)list2.get(0)).trim();

        // < > 제네릭이 추가된 이유
        List<String> list3 = new ArrayList<>();
        list3.add("abc");
        list3.add("def");
        list3.add("mei");
//        list3.add(123); // 다른 타입은 추가 불가
        list3.get(0).trim(); // String의 메서드 바로 사용 가능

        System.out.println(list3.size()); // 3

        // ArrayList는 순서가 있는 자료구조라서 인덱스가 있다.
        for (int i = 0; i < list3.size(); i++) {
            System.out.println(list3.get(i));
        }

        System.out.println("=========================");
        Iterator<String> iter = list3.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // iterator 사용법이 어렵기 떄문에 forEach가 나왔음
        // iter를 쓰면 forEach가 나오는 이유..!!
        System.out.println("=========================");
        for (String s : list3) {
            System.out.println(s);
        }



    }
}
