package day04;

public class Animal {
    // 속성(필드)
    String name;
    int age;

    // 생성자
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 행위(메서드)
    public void sound(String msg) {
        System.out.println(name + " (" + age + "살): " + msg);
    }

    // main 메서드
    public static void main(String[] args) {
        // 객체 3개 생성
        Animal cat = new Animal("초코", 2);
        Animal dog = new Animal("우유", 3);
        Animal rabbit = new Animal("흰둥이", 1);

        // 행동 실행
        cat.sound("야옹");
        dog.sound("멍멍");
        rabbit.sound("깡총깡총");
    }
}

