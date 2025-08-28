package day08;

public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("jeong");
        person.setAge(35);
        person.setAddress("경기도 동두천시");

        System.out.println(person);

        Person person1 = new Person("mei", 33, "인천시 서구");
        System.out.println(person1);
    }
}
