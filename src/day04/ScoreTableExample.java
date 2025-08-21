package day04;

public class ScoreTableExample {
    public static void main(String[] args) {
        // 학생별 과목 점수 (3명의 학생, 4과목)
        String[] students = {"김철수", "이영희", "박민수"};
        String[] subjects = {"국어", "영어", "수학", "과학"};
        int[][] scores = {
                {90, 85, 88, 92},  // 김철수
                {85, 90, 95, 88},  // 이영희
                {78, 82, 85, 90}   // 박민수
        };

        System.out.println("============= 성적표 =============");
        System.out.print("이름" + "\t\t");

        for(String subject : subjects) {
            System.out.print(subject + "\t");
        }

        System.out.print("총점" + "\t");
        System.out.println("평균");
        System.out.println("---------------------------------");

        for(int i = 0; i < students.length; i++) {
            int sum = 0;
            int scoreLen = scores[i].length;

            System.out.print(students[i] + "\t");

            for(int j = 0; j < scoreLen; j++) {
                System.out.print(scores[i][j] + "\t");
                sum += scores[i][j];
            }

            double avg = (double)sum / scoreLen;
            /*
            이렇게 쓰면 소수점 0으로 나옴 아래 방법으로 권장
            System.out.print(sum + "\t");
            System.out.println(avg);
            */
            System.out.printf("%d\t%.1f\n", sum, avg);
        }
    }
}
