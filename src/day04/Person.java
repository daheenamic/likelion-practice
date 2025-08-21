package day04;

public class Person {
    public String name; // 전체 공개
    int age; // 안 쓰면 default. 같은 패키지에서만 공개
    protected String address = "서울시"; // 같읕 패키지와 상속관계에 있다면 공개
    private String phoneNumber; // 비공개. 객체 내에서 사용 가능

    // static의 저장영역이 따로 있음.
    static int count = 0;
    static final int MAX_AGE = 150;

    public void printPhoneNumber() {
        System.out.println(phoneNumber); // 여기서는 허용 가능
    }
}
