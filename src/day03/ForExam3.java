package day03;

import java.util.Scanner;

public class ForExam3 {
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

// 구구단을 해보자
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                int result = i * j;
                System.out.print(j + " * " + i + " = " + result);
                if( j != 9 ) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // 예쁘게 찍어보자
        for (int i = 1; i <= 9; i++){
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%d * %d = %d\t", j, i, (i * j));
            }
            System.out.println();
        }

        // 값을 입력받아서 출력
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 단까지 출력 할 것인지 입력하세요: ");
        int dan = sc.nextInt();

        for (int k = 2; k <= 9; k++) {
            if(dan == (k - 1)) break;
            for (int i = 1; i <= 9; i++) {
                System.out.print(k + " * " + i + " = " + (k * i) + " ");
            }
            System.out.println();
        }
    }
}