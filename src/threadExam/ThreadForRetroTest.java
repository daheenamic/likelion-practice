package threadExam;

// 1. Thread 클래스를 상속
class ThreadForRetro extends Thread {
    private String name;

    public ThreadForRetro(String name) {
        this.name = name;
    }

    // 2. run() 메서드 오버라이드
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " 실행 중: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class ThreadForRetroTest {
    public static void main(String[] args) {
        // 3. start()로 스레드 실행
        ThreadForRetro t1 = new ThreadForRetro("❤️");
        ThreadForRetro t2 = new ThreadForRetro("💛");
        ThreadForRetro t3 = new ThreadForRetro("💙");
        ThreadForRetro t4 = new ThreadForRetro("💚");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
