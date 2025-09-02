package day10;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        // 현재 시간대의 날짜시간
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("현재(서울): " + now);

        // 다른 시간대로 변환
        ZonedDateTime newYork = now.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("뉴욕: " + newYork);

        // 특정 시간대로 생성
        ZonedDateTime paris = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Paris"));

        // 사용 가능한 시간대 확인
        Set<String> zoneIds = ZoneId.getAvailableZoneIds(); // 전체 시간대가 들어가있음
        zoneIds.stream()
                .filter(z -> z.contains("Seoul"))
                .forEach(System.out::println);
    }
}
