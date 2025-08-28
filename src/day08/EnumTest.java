package day08;

import java.time.DayOfWeek;

public class EnumTest {
    public static void main(String[] args) {
        String day;
        day = "MONDAY";
        day = "test";
        day = "jeogn";

        Day today = Day.TUESDAY;
//        today = "joeng"; // 오류

        OrderStatus status = OrderStatus.CANCELLED;
        System.out.println(status.getDescription()); // 취소
    }
}
