package day07;

public class Exam02 {
    public static void main(String[] args) {
        // 추상 클래스는 미완성된 설계도이기 때문에 객체 생성이 되지 않는다.
//        Animal animal = new Animal();

        // 타입으로의 역할은 가능
        Animal animal = new Cat();

        // 부모타입으로 자식이 확장해서 새로 구현한 메서드는 사용 불가
        // 메서드는 오버라이드되면 무조건 자식것을 사용한다.
        animal.makeSound();
    }
}
