package day06;

public class Person {

    // 필드는 private 선언하는것이 일반적
    private int age;
    private String name;

    // 필드가 모두 private하다면 어떻게 해야 될까?
    // 이 객체를 사용할 때 필드에 직접 접근하기 보다는 메서드를 이용하게 함.
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    // 위와 같은 메서드는 자주 사용되므로 getter/setter메서드라고 정의함
    public static void main(String[] args) {

    }


}
