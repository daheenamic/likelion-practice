package day06;

class Parent {
    int i = 10;
    int j = 20;
}

class Child extends Parent{

}

public class Exam01 {
    public static void main(String[] args) {
        Parent p = new Parent();
        System.out.println(p.i);

        // Child 클래스는 비어있지만 Parent 클래스를 상속 받았으므로, Parents클래스의 필드 사용가능.
        Child c = new Child();
        System.out.println(c.i);
        System.out.println(c.j);
    }
}
