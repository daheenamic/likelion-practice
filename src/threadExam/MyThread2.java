package threadExam;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread2 Start");

        for (int i = 0; i < 10; i++) {
            System.out.println("Thread2 Work Start");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread2 Work Start");
        }

        System.out.println("Thread2 End");
    }
}
