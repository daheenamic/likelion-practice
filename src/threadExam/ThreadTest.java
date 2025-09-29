package threadExam;

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("Main Start");

        MyThread myThread = new MyThread("First");
        myThread.start();

        MyThread myThread2 = new MyThread("Second");
        myThread2.start();

        MyThread myThread3 = new MyThread("Third");
        myThread3.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main Work Start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Main Work End");
        }
        System.out.println("Main End");
    }
}
