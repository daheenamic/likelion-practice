package day05;

public class PersonTest {
    public static void main(String[] args) {

        // 객체 생성후 생성자에 매개변수를 전달
        Person person = new Person("김철수", 25);

        // 메소드 체이닝
        person.setAddress("서울시 강남구").setAge(27);

        person.displayAll();

    }
}

