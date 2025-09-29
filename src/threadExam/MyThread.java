package threadExam;

public class MyThread extends Thread {

    String name;
    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " Thread Start");

        for (int i = 0; i < 10; i++) {
            System.out.println(name + " Thread Work Start");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " Thread Work Start");
        }

        System.out.println(name + " Thread End");
    }
}
