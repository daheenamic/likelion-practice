package day07;

public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();  // "싱글톤 객체 생성!" 출력
        Singleton s2 = Singleton.getInstance();  // 이미 생성된 걸 반환

        System.out.println(s1 == s2); // true (같은 객체)
    }
}