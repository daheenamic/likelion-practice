package threadExam;

class TaskThread extends Thread {
    @Override
    public void run() {
        System.out.println("작업 시작");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class DemonThread extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("배경음악 재생중...");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class JoinExam2 {
    public static void main(String[] args) {
        TaskThread taskThread = new TaskThread();
        taskThread.start();

        DemonThread demonThread = new DemonThread();
        demonThread.setDaemon(true);
        demonThread.start();

        try {
            taskThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("모든 작업 완료");
    }
}
