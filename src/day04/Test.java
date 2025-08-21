package day04;

class Book {
    String title;
    int price;
}

public class Test {
    public static void main(String[] args) {
        int i = 0; // 로컬 변수는 초기화가 필요함.
        System.out.println(i);

        // 인스턴스 변수는 객체 생성될 때 초기화가 되어서 초기화 필요 없음
        Book book = new Book();
        System.out.println(book.title);
        System.out.println(book.price);
    }
}
