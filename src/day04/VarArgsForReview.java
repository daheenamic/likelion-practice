package day04;

public class VarArgsForReview {

    // 메서드의 매개변수를 유동적으로 받을 수 있는 기능
    // 한 메서드에 한나만 선언 가능, 마지막 위치에 와야 함.

    // 타입... 변수명 형식으로 선언
    public static int sum(int... numbers) {
        int total = 0;
        // 내부적으로 배열로 처리됨
        // int[] number;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    // 일반 매개변수와 함께 사용
    // 한 메서드에 하나만 선언 가능, 마지막 위치에 와야 함.
    public static void printInfo(String name, int... scores) {
        System.out.print(name + "의 점수: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println("(총 " + scores.length + "과목)");
    }

    public static void main(String[] args) {
        // 다양한 개수의 인자 전달 가능
        System.out.println("sum(1, 2) = " + sum(1, 2)); // 3
        System.out.println("sum(1, 2, 3) = " + sum(1, 2, 3)); // 6
        System.out.println("sum(1, 2, 3, 4, 5) = " + sum(1, 2, 3, 4, 5)); // 15
        System.out.println("sum() = " + sum()); // 인자 없이도 호출 가능 = 0

        // 배열을 직접 전달도 가능
        int[] arr = {10, 20, 30};
        System.out.println("sum(arr) = " + sum(arr)); // 60
        System.out.println(sum(10, 20, 30));

        System.out.println();
        printInfo("김철수", 90, 85, 88);
        int[] arr2 = {95, 92};
        printInfo("이영희", arr2);
    }
}
