package day08;

import java.util.Objects;

public class MyClass {

    String name;

    @Override
    public String toString() {
        return "나는 " + name + "입니다.";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        MyClass myClass = (MyClass) obj;
        return Objects.equals(name, myClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.name = "mei";
        // 만약 toString을 오버라이딩 하지 않으면 day08.MyClass@6acbcfc0 이런 객체주소값이 출력된다
        System.out.println(myClass);
        System.out.println(myClass.toString());

        MyClass myClass2 = new MyClass();
        myClass2.name = "mei";

        // myClass와 myClass2는 같은 객체일까 다른객체일까
        // equals 오버라이딩 전 결과
        System.out.println(myClass == myClass2); // false
        System.out.println(myClass.equals(myClass2)); // false

        // 이런식으로 객체를 비교 할 필요가 있으면 equals를 오버라이딩 해야된다.
        // equals 오버라이딩 후 결과
        System.out.println(myClass == myClass2); // false
        System.out.println(myClass.equals(myClass2)); // true
    }
}
