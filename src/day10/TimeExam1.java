package day10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeExam1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date); // 2025-09-02

        LocalTime time = LocalTime.now();
        System.out.println(time); // 14:26:54.376169

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime); // 2025-09-02T14:30:36.038621

        LocalDate bDay = LocalDate.of(1991, 03, 20);
        LocalTime noon = LocalTime.of(12, 0);
        System.out.println(bDay); // 1991-03-20
        System.out.println(noon); // 12:00

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
        LocalDateTime myBday = LocalDateTime.of(1991,3,20,11,3);
        System.out.println("출생 시각: " + myBday.format(formatter)); // 출생 시각: 1991년 03월 20일 11시 03분
    }
}
