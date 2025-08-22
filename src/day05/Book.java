package day05;

public class Book {
    String title;
    String author;
    int price;

    // 생성자가 한 번도 정의 된 적 없다면, 컴파일러가 자동으로 디폴트 생성자를 생성함.
    // 매서드와 흡사하나, 리턴타입이 없고 매서드명이 클래스명과 동일
    public Book() {
        // 이때는 내가 직접 생성자를 만들었기 때문에, 컴파일러가 만든게 아님.
        System.out.println("Book() 생성");

        // Book 이라는 객체가 만들어졌을 때 부터 지정한 값으로 초기화를 하고 싶다는 뜻.
        title = "java";
        author = "정다희";
        price = 30000;
    }

    // 생성자 오버로딩도 가능하다.
    public Book(String title) {
        this.title = title; // 명확하게 써줘야 한다.
        // this.title - 객체의 멤버 필드
        // title - 매개변수로
    }

    public static void main(String[] args) {
        Book book = new Book(); // (): 생성자
        Book book2 = new Book("Spring");

        // 생성자에서 생성한 값이 들어가있음
        System.out.println(book.title);
        System.out.println(book.author);
        System.out.println(book.price);

        System.out.println(book2.title);

        // 생성자는 객체가 생성될 때 단 한번만 호출 됨 - 임의로 호출 불가능.
        // book2.Book2("JavaScript"); // 이렇게 한번 더 호출하는 건 불가능 - error
    }
}
