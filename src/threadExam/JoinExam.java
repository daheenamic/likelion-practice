package threadExam;

class SumThread extends Thread {
    @Override
    public void run() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("[sumThread] 계산 종료");
    }
}

public class JoinExam {
    public static void main(String[] args) {
        // 메인 스레드가 시작되고, 다른 작업을 진행함
        System.out.println("[Main] 작업 시작");
        System.out.println("[Main] 다른 작업 진행 중...");

        SumThread sum = new SumThread();
        sum.start(); // sumThread를 시작하지만, 아직 결과는 안 나옴 (비동기 실행)

        // sumThread가 계산하는 동안에도 Main은 계속 실행됨을 확인
        System.out.println("[Main] sumThread가 계산하는 동안에도 Main은 계속 실행됨");

        // 이제 sumThread의 결과가 필요하므로, 끝날 때까지 대기 (join)

        try {
            sum.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("[Main] sumThread 계산이 끝났으니 결과 활용하여 마무리");
    }
}
