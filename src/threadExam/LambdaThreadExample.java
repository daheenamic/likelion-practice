package threadExam;

public class LambdaThreadExample {
    public static void main(String[] args) {
        // 람다 표현식으로 Runnable 구현
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("람다 스레드: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        thread1.start();
    }
}