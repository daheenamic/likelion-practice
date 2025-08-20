package day03;

public class WhilePractice {
    public static void main(String[] args) {
        // while문을 사용하여 1부터 100까지의 합을 구하기.
        int sum = 0;
        int i = 1;
        while (i <= 100) {
            sum += i;
            i++;
        }
        System.out.println("1부터 100까지의 합: " + sum);

        // do-while문을 사용하여 10부터 1까지 역순으로 출력
        i = 10;
        System.out.print("10부터 1까지 역순으로 출력: ");
        do {
            System.out.print(i + " ");
            i--;
        } while (i >= 1);

        System.out.println();

        // while문과 continue를 사용하여 1~20 사이의 홀수만 출력
        i = 1;
        System.out.print("1~20 사이의 홀수만 출력: ");
        while (i < 20) {
            if(i % 2 == 0) {
                i++;
                continue;
            }
            System.out.print(i + " ");
            i++;
        }

        System.out.println();

        // do-while문에서 조건이 처음부터 false여도 1회 실행됨을 확인하는 코드를 작성
        i = 0;
        do {
            System.out.println("do-while 출력 확인");
        } while (i > 10);
    }
}
