package day03;

public class ArrayCopyExam {
    public static void main(String[] args) {
        int i = 10;
        int copyI = i;

        copyI = 20;
        System.out.println(i); // 결과 10

        /* --------------------------------- */

        int[] iarr = {1, 2, 3};
        int[] copyIarr = iarr;

        copyIarr[0] = 100;

        System.out.println(iarr[0]); // 결과 100

        /* --------------------------------- */

        int[] iarr2 = {4, 5, 6};
        int[] copyIarr2 = new int[iarr2.length];

        for(int j = 0; j < iarr2.length; j++) {
            copyIarr2[j] = iarr2[j];
        }

        for(int val : copyIarr2) {
            System.out.println(val);
        }

        int[] ori1 = {1,2,3};
        int[] ori2 = {4,5,6,7};

        //카피할 배열
        int[] copy = new int[ori1.length + ori2.length];
    }
}
