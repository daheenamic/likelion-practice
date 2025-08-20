package day03;

public class ForExam {
    public static void main(String[] args) {
        /*
        int i = 0; // 초기화
        while (조건식) {
            탈출 할 수 있는 문장
        }
        */

        // for (초기화; 조건식; 증감식) { 실행할문장 }
        for ( int i = 1; i <= 10; i++ ) {
            System.out.println(i);
        }

        // 변수의 범우 - 언어마다 차이가 있을 수 있다.
        // 자바는 변수의 스코프가 블럭단위
        int j = 0;
        for ( ; j<10; j++ ) { // 초기화한 부분이 생략되어 있지만 세미콜론(;)을 생략하면 안된다.
            System.out.println(j);
        }
    }
}
