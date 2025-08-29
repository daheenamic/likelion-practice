package day09;

import java.util.*;

public class PersonDemo {
    public static void main(String[] args) {
        // person 객체 5개 만들기
        // 이렇게 생성한 person 객체들을 List, Set, Map에 각각 담기
        Person person1 = new Person("kim", "900101", "010-1111-1111", "서울");
        Person person2 = new Person("kang", "900102", "010-2222-2222", "경가");
        Person person3 = new Person("lee", "900103", "010-3333-3333", "강릉");
        Person person4 = new Person("park", "900104", "010-4444-4444", "광주");
        Person person5 = new Person("jeong", "900105", "010-5555-5555", "부산");

        // 객체를 리스트화
        Person person[] = {person1, person2, person3, person4, person5};

        // 1. List
        List<Person> personList = new ArrayList<>();
        personList.addAll(Arrays.asList(person));

        System.out.println("========== List에 담기 ========== ");
        System.out.println(personList);

        // 2. Set
        Set<Person> personSet = new HashSet<>(Arrays.asList(person));

        System.out.println("========== Set에 담기 ========== ");
        System.out.println(personSet);

        // 3. Map
        Map<String, Person> personMap = new HashMap<>();
        personMap.put(person1.getIdNumber(), person1);
        personMap.put(person2.getIdNumber(), person2);
        personMap.put(person3.getIdNumber(), person3);
        personMap.put(person4.getIdNumber(), person4);
        personMap.put(person5.getIdNumber(), person5);

        System.out.println("========== Map에 담기 ========== ");
        System.out.println(personMap);

        System.out.println("========== 사람 찾기 ========== ");
        Scanner sc = new Scanner(System.in);
        System.out.print("찾을 사람의 ID를 입력하세요: ");
        String id = sc.nextLine();
        if (personMap.get(id) != null) {
            System.out.println(personMap.get(id));
        } else {
            System.out.println("찾는 사람이 없습니다.");
        }
    }
}
