package day04;

public class Exam {
    public static void main(String[] args) {
        // 인스턴스화 - 클래스(설계도를 이용해서)를 객체(물건)를 만들어 내는 것.
        // new - 인스턴스화 할 수 있는 예약어

        // 이렇게 생성만 하면 쓸 수 없다. 어디에 만들어져 있는지 모르기 때문에 못 씀.
        new Pen();

        // 변수에 담아놔야 쓸 수 있다.
        Pen pen = new Pen();
        pen.write("안녕");
    }
}
