package day10;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Practice {

    public static String dDay(LocalDate baseDate, LocalDate targetDate) {
        long dDay = Math.abs(ChronoUnit.DAYS.between(baseDate, targetDate));

        String dDayStr = null;

        if(targetDate.isAfter(baseDate)) dDayStr = "D-" + dDay;
        else if(targetDate.isBefore(baseDate)) dDayStr = "D+" + dDay;
        else dDayStr = "D-DAY";

        return dDayStr;
    }

    public static LocalDate businessDay(LocalDate date, int days) {
        LocalDate result = date;
        int addDay = 0;

        while (addDay < days) {
            result = result.plusDays(1);
            if ( (result.getDayOfWeek() != DayOfWeek.SATURDAY)
                    && (result.getDayOfWeek() != DayOfWeek.SUNDAY) ) {
                addDay++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        // D-Day 계산하는데 기준 날짜 입력이 이상해서 제외
        // 기념일 계산기 만들 때 넣으면 될듯
        System.out.print("기준 날짜 입력(yyyy-mm-dd): ");
        String str1 = sc.nextLine();
        */

        System.out.print("디데이를 계산할 날짜 입력(yyyy-mm-dd): ");
        String str2 = sc.nextLine();

//        LocalDate baseDate = LocalDate.parse(str1);
        LocalDate today = LocalDate.now();
        LocalDate targetDate = LocalDate.parse(str2);
        System.out.println("디데이 계산 결과: " + dDay(today, targetDate));

        System.out.println("=======================================");

        System.out.print("영업일을 계산할 기준 일자 입력(yyyy-mm-dd): ");
        String str3 = sc.nextLine();
        LocalDate baseDate = LocalDate.parse(str3);

        System.out.print("영업일을 계산한 일 수 입력: ");
        int days = Integer.parseInt(sc.nextLine());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        LocalDate businessDays = businessDay(baseDate, days);
        System.out.println(days + "영업일 후: " + businessDays.format(formatter));
    }
}
