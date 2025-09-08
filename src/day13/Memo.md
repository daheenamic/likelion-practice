### Q16. 다음 코드의 실행 결과로 옳은 것은 무엇인가요?
```java
public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }
}
```
(1) try catch  
(2) try catch finally  
(3) try finally  
(4) catch finally  
(5) 실행 오류 

> ✅ 정답 (2) try catch finally  
> try 블록이 실행되고, 예외를 던진다. 예외가 발생했기 때문에 catch 블록으로 넘어가 "catch" 가 출력된다.  
> 예외 처리와 상관 없이 finally는 항상 실행되어 finally가 출력된다.  
> try 안에서 return 되더라도 finally는 실행 됨.  


***

### Q17. 다음 중 `StringBuilder` 클래스에 대한 설명으로 **틀린 것**은 무엇인가요?

(1)`StringBuilder`는 문자열을 변경할 수 있다.  
(2)`StringBuilder`는 `String` 클래스보다 성능이 우수하다.  
(3)`StringBuilder`는 멀티스레드 환경에서 안전하다.  
(4)`append()` 메서드를 사용해 문자열을 추가할 수 있다.  
(5)`StringBuilder`는 `toString()` 메서드를 제공한다.  

> ✅ 정답 (3)`StringBuilder`는 멀티스레드 환경에서 안전하다.  
> StringBuilder는 동기화가 없어서 멀티스레드에서 안전하지 않음. -> StringBuffer 사용  
> String클래스는 불변객체이기 때문에 연결 시 계속 새 객체를 생성 -> StringBuilder는 가변이기 때문 빠름  

```java
public class StringBuilderSimpleExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(", ").append("world!");
        System.out.println(sb.toString());  // 출력: Hello, world!
    }
}
```

***

### Q18. 다음 중 **메서드 오버라이딩**에 대한 조건으로 **틀린 것**은 무엇인가요?

(1) 메서드 이름이 같아야 한다.  
(2) 매개변수의 개수와 타입이 같아야 한다.  
(3) 리턴 타입이 같거나 하위 타입이어야 한다.  
(4) 접근 제어자는 부모 클래스보다 더 좁게 제한할 수 있다.  
(5) 상속 관계에서만 오버라이딩이 가능하다.  

> ✅ 정답 (4) 접근 제어자는 부모 클래스보다 더 좁게 제한할 수 있다.  
> 오버라이딩은 접근 범위를 같거나 더 넓게만 바꿀 수 있음.  
> 더 좁게 만들면 부모 타입으로 참조할 때 접근 불가해질 수 있어서 다형성을 해침.  

```java
class Parent {
    protected void sayHello() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    // 컴파일 오류:
    // "attempting to assign weaker access privileges; was protected"
    @Override
    void sayHello() { // protected → default (더 좁은 접근 권한)
        System.out.println("Hello from Child");
    }
}
```

***

### Q19. 다음 코드의 실행 결과는 무엇인가요?
```java
class A {
    A() { System.out.println("A 생성자"); }
}

class B extends A {
    super();
    B() { System.out.println("B 생성자"); }
}

public class Test {
    public static void main(String[] args) {
        B b = new B();
    }
}
```

(1) A 생성자
(2) B 생성자
(3) A 생성자 B 생성자
(4) 컴파일 오류
(5) 실행 오류

> ✅ 정답 (3) A 생성자 B 생성자  
> B를 만들면 먼저 부모 A가 만들어져야 하므로 super()가 암묵적으로 호출됨  
> 모든 생성자의 첫 줄에는 this(...) 또는 super(...)가 와야함  
> 상속 계층 위에서 아래 순으로 생성자가 실행  
> 부모가 기본생성자(매개변수가없는)가 없고 매개변수가 있는 생성자가 있을때, super(args) 호출은 무조건 해야 됨 -> 안하면 컴파일 오류

```java
class Single {
    Single() {
        // 여기에도 사실 super(); 가 자동 삽입됨
        System.out.println("Single 생성자");
    }
}

public class Test {
    public static void main(String[] args) {
        new Single();
    }
}
```

***