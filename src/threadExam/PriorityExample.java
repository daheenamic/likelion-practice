package threadExam;

public class PriorityExample {
    public static void main(String[] args) {
        Thread highPriority = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("높은 우선순위: " + i);
            }
        });

        Thread lowPriority = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("낮은 우선순위: " + i);
            }
        });

        highPriority.setPriority(Thread.MAX_PRIORITY); // 10
        lowPriority.setPriority(Thread.MIN_PRIORITY);  // 1

        highPriority.start();
        lowPriority.start();
    }
}
