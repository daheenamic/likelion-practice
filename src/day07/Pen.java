package day07;

public class Pen {
    public void write() {
        System.out.println("쓰다");
    }

    // 오버로딩
    public void write(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        BallPen bp = new BallPen();
        bp.write();
        bp.write("내용");
    }
}

class BallPen extends Pen {
    // 오버라이딩은 상속관계에서만 가능
    @Override
    public void write() {
        System.out.println("쓰다");
    }
}


