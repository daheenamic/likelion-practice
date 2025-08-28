package day07;

public class Cat extends Animal {
    public void eat() {
        System.out.println("먹는다");
    }

    public void walk() {
        System.out.println("걷다.");
    }

    // 추상클래스의 메서드를 강제로 구현 해야한다.
    // 해당 기능을 일관성있게 구현하도록 게시함.
    public void makeSound() {
        System.out.println("야옹");
    }
}
