package threadExam;

public class SynchronizedCounter {
    private int count = 0;

    // 동기화된 메서드
    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented, count=" + counter.getCount());
                }
            });
            threads[i].start();
        }

        // 모든 스레드 종료 대기
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("최종 카운트: " + counter.getCount()); // 10000
    }
}