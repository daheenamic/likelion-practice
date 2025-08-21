package day04;

public class PersonExam {
    public static void main(String[] args) {

        // Person이 가진 필드(값)를 이용하려면 인스턴스 생성, 초기화를 해야 한다.
        Person person = new Person();
        person.name = "정다희";
        person.age = 35;

        // static 필드는 인스턴스화 하지 않고 사용 가능
        Person.count++;
        System.out.println(Person.count);
        System.out.println(Person.MAX_AGE);

        Person jeong = new Person();
        jeong.name = "정다희";
        jeong.count++;

        Person choi = new Person();
        choi.name = "최지수";
        choi.count++;

        // 각각 joeng, choi라는 객체를 생성 했지만,
        //  static이기 때문에 이미 메모리에 할당되어 올라가있어서 공유되어 사용된다.
        System.out.println(jeong.count);
        System.out.println(choi.count);

        // 독립된 저장 공간을 가족 있기 때문에 각각 다른 출력값이 나온다.
        System.out.println(jeong.name);
        System.out.println(choi.name);
    }
}
