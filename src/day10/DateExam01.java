package day10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateExam01 {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now); // Tue Sep 02 13:18:23 KST 2025

        Date birthDay = new Date(1991, 3, 20);
        System.out.println(birthDay); // Mon Apr 20 00:00:00 KST 3891

        // Date Class는 월이 0부터 시작해서 11까지 있다.
        // 입력할 때는 -1해야 하고, 출력할 때는 +1 해야 된다.
        birthDay = new Date(1991,2,20);
        System.out.println(birthDay); // Fri Mar 20 00:00:00 KST 3891

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(birthDay)); // 3891-03-20 00:00:00

        // java.util.Date의 오래된 생성자 new Date(int year, int month, int date)는 연도를 그대로 받지 않고
        // 1900을 기준으로 더하는 방식을 사용, Calendar나 LocalDateTime (java.time API)를 쓰는 게 표준
        // getYear()은 또 1991이 나옴. 헷갈리고 설계 자체가 구식이니까 쓰지말자
        System.out.println(birthDay.getYear()); // 1991
        System.out.println(birthDay.getMonth()); // 2
        System.out.println(birthDay.getDate()); // 20

        Calendar calendar = Calendar.getInstance(); // Calendar의 자식클래스
        System.out.println(calendar.get(Calendar.YEAR)); // 2025
        System.out.println(calendar.get(1)); // 2025
        System.out.println(calendar.get(Calendar.MONTH)); // 8 -> 월의 인덱스를 출력해서 +1 해야됨
        System.out.println(calendar.get(Calendar.MONTH) + 1); // 9
        System.out.println(calendar.get(Calendar.DATE)); // 2

        calendar.set(Calendar.YEAR, 1991);
        System.out.println(calendar.get(Calendar.YEAR)); // 1991
        calendar.set(1991, 3, 20);
        System.out.println(calendar.get(Calendar.MONTH)); // 3
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 7 - 토요일 (1:일요일 ~ 7:토요일)

        System.out.println("====================================");
        Calendar now2 = Calendar.getInstance();
        System.out.println(now2.getActualMaximum(Calendar.DATE)); // 30: 해당월의 마지막날
        System.out.println(now2.get(Calendar.DAY_OF_WEEK)); // 3

        // 월을 입력받고 해당월의 달력을 뿌려주세요
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();

        System.out.print("달력을 만들 년도 입력: ");
        int year = sc.nextInt();
        System.out.print("달력을 만들 월 입력: ");
        int month = sc.nextInt();

        cal.set(year, month - 1, 1);

        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        int maxDay = cal.getActualMaximum(Calendar.DATE);

        System.out.println();
        System.out.println("==== " + year + "년 " + month + "월 달력 ====");
        System.out.println("일 월 화 수 목 금 토");

        for (int i = 1; i < startDay; i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= maxDay; day++) {
            System.out.printf("%2d ", day);
            if ((day + startDay - 1) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
