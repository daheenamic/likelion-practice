package day07;

class Parent {
    int i = 5;

    public Parent() {
        System.out.println("Parent 생성자");
    }

    public int getI() {
        return i;
    }
}

class Child extends Parent {
    int i = 10;

    public Child() {
        System.out.println("Child 생성자");
    }

    public int getI() {
        return i;
    }

    public void print() {
        System.out.println(i);
    }
}

public class Exam01 {
    public static void main(String[] args) {
        Parent p = new Parent();
        System.out.println(p.i);
        System.out.println(p.getI());

        System.out.println("====================");
        Parent pc = new Child();
        System.out.println(pc.i);
        System.out.println(pc.getI());

        System.out.println("====================");
        Child c = new Child();
        System.out.println(c.i);
        System.out.println(c.getI());

        System.out.println("====================");
        test(p);

        System.out.println("====================");
        test(c);
    }

    public static void test(Parent p) {
        System.out.println(p.i);
        System.out.println(p.getI());

        if (p instanceof Child) {
            System.out.println("====================");
            ((Child)p).print();
        }
    }
}
