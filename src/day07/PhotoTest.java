package day07;

public class PhotoTest {
    public static void main(String[] args) {
        // 추상클래스도 타입으로 사용할 수 있다.
        // 마찬가지로 인터페이스도 타입으로 사용 가능하다.
        Drawable d = new Photo("a.png", 200, 500);

        // 어디까지 접근이 가능할까
        d.draw();
        d.erase();
    //    d.resize(); // 타입이 Drawble이기 때문에 접근 불가능

        // 타입을 인터페이스로 지정했을때 장점은 접근을 제한을 할 수 있다는 것

    }
}
