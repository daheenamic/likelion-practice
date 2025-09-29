package threadExam;

public class MyRunnable implements Runnable{

    String name;
    MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " Runnable Start");

        for (int i = 0; i < 10; i++) {
            System.out.println(name + " Runnable Working...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(name + " Runnable End");
    }
}
