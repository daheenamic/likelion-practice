package day05;

public class StaticExam {
    // 1. 필드 차이
    int i; // 인스턴스 변수 - 객체마다 따로 존재
    static int si; // 클래스 변수(정적 변수) - 클래스에 딱 1개만 존재

    // i 는 new StaticExam() 할 때마다 새로 생성됨.
    // si는 클래스 전체에서 공유되는 하나뿐인 값

    // 2. 인스턴스 메서드
    public void method() {
        System.out.println(i); // 인스턴스 변수 접근 가능
        System.out.println(si); // static 변수 접근 가능
        smethod();

        // 객체가 있어야 실행 가능 (new StaticExam().method();
        // 객체 내부를 다루는것이 목적이므로 인스턴스 필드/메서드와 static 필드/메서드 모두 접근 가능.
    }

    // 3. static 메서드
    public static void smethod() {
        //System.out.println(i); // 객체가 없으니 인스턴스 변수 접근 불가
        System.out.println(si); // static 변수는 접근 가능

        // 클래스 차원에서 호출 StaticExam.smethod();
        // 객체가 없어도 실행되므로, 인스턴스 변수/메서드에는 직접 접근 불가
        // 오직 static 자원만 바로 접근 가능
    }

    public static void main(String[] args) {
        System.out.println(si); // static 변수 바로 사용 가능
        smethod(); // static 메서드 바로 호출 가능

        // 여기도 static한 메서드기 때문에 int i는 사용 불가능

        // 인스턴스 멤버 접근하려면 객체를 만들어야 함 = 인스턴스화
        StaticExam se = new StaticExam();
        System.out.println(se.i);

        // main도 static - 객체가 없는 상태에서 프로그램 시작
        // 따라서 i같은 인스턴스 변수는 직접 못 쓰고, new로 객체를 생성해야 접근 가능
    }
}
