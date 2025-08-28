package day07;

public class ObjectTest {
    public static void main(String[] args) {
        ObjectTest ot = new ObjectTest();
        // 모든 클래들의 래퍼런스 변수를 이용해서 사용될 수 있는 매서드들을 볼 수 있다.
        // 만들지 않아도 Object가 가지고 있는 메서드들을 볼 수 있음.
        // ot. 하면 여러가의 매서드들이 나옴.
        System.out.println(ot.toString());

    }
}
