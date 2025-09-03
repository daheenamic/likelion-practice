package day11;

import java.util.Scanner;

// 사용자 정의 예외 객체 실습
public class ExceptionExam6 {

    public static void inputScore(int score) throws InvalidScoreException {

        // score는 점수 값을 나타냄. 0~100 까지만 입력 받고 싶음.
        // 만약 0~100 사이 이외의 값이 들어왔을 때 예외처리 하고 싶음.

        if (score < 0 || score > 100) {
        // 일반적인 처리
//            System.out.println("점수는 0~100 사이의 값만 입력 가능합니다.");
//            return;
            throw new InvalidScoreException("[parameter로 넘긴 메세지] 점수는 0~100 사이만 입력 가능합니다.");
        }

        System.out.println("학생의 점수: " + score);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("점수를 입력하세요: ");
        int score = sc.nextInt();
        try {
            inputScore(score);
        } catch (InvalidScoreException e) {
            System.out.println(e.getMessage());
        }
    }
}
