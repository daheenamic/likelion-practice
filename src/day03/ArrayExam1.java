package day03;

public class ArrayExam1 {
    public static void main(String[] args) {
        String name = "정다희";
        String name2 = "최지수";
        String name3 = "정뭉탱";

        System.out.println(name);
        System.out.println(name2);
        System.out.println(name3);

        // 선언
        int[] iarr;
        int iarr2[];

        // 배열의 생성
        iarr = new int[3];

        // index를 사용해서 배열의 요소에 접근
        iarr[0] = 10;

        System.out.println(iarr[0]); // 10
        System.out.println(iarr[1]); // 0
        System.out.println(iarr[2]); // 0

        int i = iarr[0];
        System.out.println(i); // 10

        System.out.println("=======================");

        for(int j = 0; j < iarr.length; j++) {
            System.out.println(iarr[j]);
        }

        System.out.println("=======================");

        // foreeach == 1.5 추가된 문법
        for(int val : iarr) {
            System.out.println(val);
        }

        System.out.println("=======================");

        String[] strArr = new String[3];
        strArr[0] = "aaaa";
        strArr[1] = "bbbb";
        strArr[2] = "cccc";

        for(String val : strArr) {
            System.out.println(val);
        }



    }
}
