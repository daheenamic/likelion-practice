package threadExam.practice01;

import java.util.Random;

public class IncrementCounter implements Runnable{
    @Override
    public void run() {
        Random random = new Random();

        for (int i = 1; i <= 100; i++) {
            System.out.println("Increment: " + i);

            int delay = random.nextInt(11);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
