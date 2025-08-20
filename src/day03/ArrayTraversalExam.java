package day03;

public class ArrayTraversalExam {
    public static void main(String[] args) {
        int[] scores = {95, 87, 66, 73, 82};

        // 1. 배열의 모든 요소를 출력
        for(int val : scores) {
            System.out.println(val);
        }

        // 2. 총점, 평균 구하기
        int sum = 0;
        float avg = 0;
        int len = scores.length;
        for(int val : scores) {
            sum += val;
        }
        avg = sum / len;
        System.out.println("총점: " + sum);
        System.out.println("평균: " + avg);

        // 3. 최대값 찾기
        int max = 0;
        for (int val : scores) {
            if(val > max) {
                max = val;
            }
        }
        System.out.println("최대값: " + max);

        String[] strArr;
        Object[] objArr;
    }
}
