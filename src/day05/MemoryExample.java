package day05;

public class MemoryExample {

    // static 필드 (클래스 변수)
    static int staticCounter = 0; // 클래스 로딩 시 딱 1번 메모리에 올라감

    // 인스턴스 필드 (객체 변수)
    int instanceCounter = 0; // new 할 때마다 새로 생성됨

    // 인스턴스 메서드
    public void increaseInstanceCounter() {
        instanceCounter++;
        System.out.println("instanceCounter: " + instanceCounter);
    }

    // 클래스 메서드 (static 메서드)
    public static void increaseStaticCounter() {
        staticCounter++;
        System.out.println("static 카운터 = " + staticCounter);
    }

    // 인스턴스 메서드 안에서 지역 변수 사용 예시
    public void localVariableExample() {
        int localVal = 100; // 지연변수: 메서드 실행할 때 메모리에 생성
        System.out.println("지역변수(localVal) = " + localVal);
        // 메서드 종료 후 localVar는 사라짐
    }

    public static void main(String[] args) {
        // 1. static 필드는 클래스 로딩될 때 이미 메모리에 올라감
        System.out.println("처음 staticCounter = " + staticCounter);

        // 2. new 연산자를 사용하면 새로운 인스턴스가 생성됨
        MemoryExample obj1 = new MemoryExample();
        MemoryExample obj2 = new MemoryExample();

        // 3. 인스턴스 메서드는 객체(참조 변수)를 통해 호출
        obj1.increaseInstanceCounter(); // obj1의 instanceCounter = 1
        obj1.increaseInstanceCounter(); // obb1의 instanceCounter = 2
        obj2.increaseInstanceCounter(); // obj2의 instanceCounter = 1 (obj1과 별개)

        // 4. 클래스 메서드는 클래스명으로 호출 가능 (static)
        MemoryExample.increaseStaticCounter(); // staticCounter = 1
        MemoryExample.increaseStaticCounter(); // staticCounter = 2

        // 5. 지역 변수는 메서드 실행 시에만 존재
        obj1.localVariableExample(); // localVal는 메서드 종료 시 사라짐

        // 6. 가비지 컬렉션 예시 (obj1 참조 제거)
        obj1 = null; // 이제 obj1 인스턴스는 더 이상 참조되지 않음 -> 나중에 GC가 수거
        System.gc(); // GC 요청 (바로 실행된다는 보장은 없음)
        System.out.println("obj1 참조 해체 후 GC 요청 완료");
    }
}
