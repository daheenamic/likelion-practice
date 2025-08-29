package day09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
    public static void main(String[] args) {
        // List에 50명의 Person이 저장되어 있다고 가정
        // 이름이 최지수인 사람의 주소를 확인하고 싶으면 모든 리스트를 다 순회해야 한다.
        // 그래서 [키:값]의 형태로 데이터 관리가 되어야 한다.
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("mei", "010-4242-8743");
        phoneBook.put("luna", "010-8901-0320");
        phoneBook.put("moong", "010-7777-7777");
        phoneBook.put("moong", "010-1234-5678"); // key가 중복되면 교체된다

        System.out.println(phoneBook.get("mei")); // 010-4242-8743

        Set<String> keys = phoneBook.keySet();
        System.out.println(keys); // [mei, moong, luna]

        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(phoneBook.get(key));
        }

        System.out.println("========================");

        for (String key : keys) {
            System.out.println(key + ": " + phoneBook.get(key));
        }

        System.out.println("========================");

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }



    }
}
