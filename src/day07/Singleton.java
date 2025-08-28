package day07;

class Singleton {
    // 1. 자기 자신을 참조하는 static 변수
    private static Singleton instance;

    // 2. 생성자를 private으로 막아 외부에서 new 불가
    private Singleton() {
        System.out.println("싱글톤 객체 생성!");
    }

    // 3. 유일한 인스턴스를 반환하는 메서드
    public static Singleton getInstance() {
        if (instance == null) {     // 없으면 만들고
            instance = new Singleton();
        }
        return instance;            // 있으면 그대로 반환
    }
}