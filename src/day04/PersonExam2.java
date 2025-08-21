package day04;

public class PersonExam2 {
    public static void main(String[] args) {
        Person person = new Person();

        person.name = "jeong";
        person.age = 20; // 같은 패키지라서 사용가능. 패키지 달라지면 사용 불가.
        person.address = "경기도"; // 같은 패키지라서 사용가능. 패키지 달라지면 상속 관계여야 사용 가능.
//        person.phoneNumber = "01012341234"; // private라서 접근 불가능

    }
}
