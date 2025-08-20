package day03;

public class WhileExam {
    public static void main(String[] args) {
        int i = 0;
        while (i < 4) {
            i++;
            if((i % 2) == 0) {
                System.out.println("안녕" + i);
            }
        }

        i = 0;
        while (true) {
            if(i == 11) break; // 단순한 문장을 쓸 때는 블럭 생략 가능.
            System.out.println(i++);
        }

        i = 0;
        while(i++ < 10){
            if(i == 5)
                continue;
            System.out.println(i);
        }
    }
}
