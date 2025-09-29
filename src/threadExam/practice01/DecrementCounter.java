package threadExam.practice01;

import java.util.Random;

public class DecrementCounter implements Runnable{
    @Override
    public void run() {
        Random random = new Random();

        for (int i = 100; i > 0; i--) {
            System.out.println("Decrement: " + i);

            int delay = random.nextInt(11);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
