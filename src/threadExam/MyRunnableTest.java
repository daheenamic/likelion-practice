package threadExam;

public class MyRunnableTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable("[1]"));
        Thread thread2 = new Thread(new MyRunnable("[2]"));
        Thread thread3 = new Thread(new MyRunnable("[3]"));

        thread.start();
        thread2.start();
        thread3.start();

        System.out.println("Main Thread End");
    }
}
