package day07;

// 추상클래스는 미완성 메서드를 가질 수 있는 클래스이다.
// 인터페이스는 껍데기만 갖고 있으며, 구현체가 없는 것이 기본이다.
public interface Drawable {
    void draw(); // 추상 메서드(구현부가 없다)
    void erase();

    // java version 8에서 추가된 기능
    // 1. default 메서드
    default void defaltTest() {
        // 필요하면 자식 클래스가 오버라이드해서 사용하는것이 목적
        System.out.println("default Test");
    }

    // 2. static 메서드
    static void showInfo() {
        System.out.println("static Test");
    }
}
