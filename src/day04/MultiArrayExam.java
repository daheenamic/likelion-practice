package day04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MultiArrayExam {
    public static void main(String[] args) {
        // 선언 - [][] 몇개냐가 차원을 결정함.
        int[][] iarr;
        iarr = new int[3][2];

        int[][] iarr2 = new int[2][];
        iarr2[0] = new int[2];  // 값이 아니라 배열(객체)를 담아줘야 한다.
        iarr2[0][0] = 10;       // 값을 담아야 함
        iarr2[1] = new int[10]; // 이렇게 객체 생성을 해줘야
        iarr2[1][0] = 20;       // 값을 담을 수 있음

        System.out.println(iarr2[0][0]);

        // 이렇게도 가능하지만 .. 권장하지 않음 List나 Map 사용 권장
        int[][][][] iarr4 = new int[2][][][];

        int[] iarr5 = {1, 2, 3};

        // matrix[3][3]의 형태
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        // 8을 출력
        System.out.println(matrix[2][1]);

        int[][] iarr7 = {{1, 2},{3, 4, 5, 6, 7},{8}};
        // 5를 출력
        System.out.println(iarr7[1][2]);

        int[] iarr8 = {1, 2, 3};
        System.out.println(Arrays.toString(iarr8));


    }
}
