package day10;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class PeriodDurationExample {
    public static void main(String[] args) {
        // Period - 날짜 간격
        LocalDate jBirth = LocalDate.of(1991,3,20);
        LocalDate cBirth = LocalDate.of(1993,2,23);
        LocalDate today = LocalDate.now();

        Period jAge = Period.between(jBirth, today);
        Period cAge = Period.between(cBirth, today);
        System.out.printf("다희 나이: %d년 %d개월 %d일%n", jAge.getYears(), jAge.getMonths(), jAge.getDays());
        System.out.printf("지수 나이: %d년 %d개월 %d일%n", cAge.getYears(), cAge.getMonths(), cAge.getDays());


        // Duration - 시간 간격
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 30);

        Duration workTime = Duration.between(start, end);
        System.out.println("근무 시간: " + workTime.toHours() + "시간 " +
                (workTime.toMinutes() % 60) + "분");

        // Instant - 타임스탬프
        Instant instant = Instant.now();
        System.out.println("타임스탬프: " + instant);
        // 에포크(epoch): 1970-01-01T00:00:000Z (UTC) 기준
        System.out.println("에포크 초: " + instant.getEpochSecond());

        // LocalDateTime - 사람이 읽는 날짜, 시간 (타임존 없음)
        // ZonedDateTime - 사람이 읽는 날짜.시간 + 타임존 (지역반영)
        // Instant - 컴퓨터가 읽을 목적. 항상 UTC기준 (서버/DB/로그 기록등에 자주쓰임)
    }
}
