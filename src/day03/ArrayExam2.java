package day03;

public class ArrayExam2 {
    public static void main(String[] args) {
        // new 연산자로 생성 (기본값으로 초기화)
        int[] arr1 = new int[5];
        for(int val : arr1) {
            System.out.print(val + " ");
        }

        System.out.println();

        // 선언과 동시에 초기화
        int[] arr2 = {10, 20, 30, 40, 50};
        for(int val : arr2) {
            System.out.print(val + " ");
        }

        // new 연산자와 함께 초기화
        int [] arr3 = new int[]{10, 20, 30}; // 배열 크기를 넣으면 안된다.

        // 선언 후 나중에 생성
        int[] arr4;
        arr4 = new int[3];

        System.out.println();
        System.out.println("==================");

        // 1부터 100까지 숫자 채우기
        int[] arr100 = new int[100];
        int val = 1;
        for(int idx : arr100) {
            arr100[idx] = val;
            val++;
            System.out.println(arr100[idx]);
        }
    }
}
