package day06;

class Parent1 {

}

class Child1 extends Parent1 {

}

public class Exam02 {
    // 1. 부모(조상)는 자식(자손)을 가리킬 수 있다.
    Parent1 p = new Child1(); // 부모 타입으로 자식 객체 생성 가능
//    Child1 c = new Parent1(); // 자식 타입으로 부모 객체 생성 불가능 - error
}
