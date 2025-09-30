package streamExam;

import java.util.Optional;
import java.util.NoSuchElementException;

class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class OptionalTest {
    public User findUser(int id) {
        if(id == 1) {
            return new User("dahee");
        }
        return null;
    }

    public Optional<User> findUserOptional (int id) {
        if(id == 1) {
            return Optional.of(new User("dahee"));
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        OptionalTest test = new OptionalTest();

        printHeader("1. null 기반 방식의 문제점 (안전하게 처리)");
        User u1 = test.findUser(1);
        if (u1 != null) {
            System.out.println(u1.getName()); // dahee
        }
        User u2 = test.findUser(2);
        System.out.println(u2 != null ? u2.getName() : "사용자를 찾을 수 없습니다.");

        printHeader("2. Optional 기본: ifPresentOrElse");
        test.findUserOptional(1)
                .ifPresentOrElse(user -> System.out.println("사용자 이름은 " + user.getName() + "입니다."),
                        () -> System.out.println("사용자를 찾을 수 없습니다."));

        test.findUserOptional(2)
                .ifPresentOrElse(user -> System.out.println("사용자 이름은 " + user.getName() + "입니다."),
                        () -> System.out.println("사용자를 찾을 수 없습니다."));

        printHeader("3. orElse vs orElseGet (차이)");
        // orElse는 값이 있어도 우변을 '항상' 평가(호출)함
        User orElse1 = test.findUserOptional(1).orElse(createGuest()); // guest 생성 메시지 출력됨
        User orElse2 = test.findUserOptional(2).orElse(createGuest()); // guest 생성 메시지 출력됨
        System.out.println(orElse1.getName());
        System.out.println(orElse2.getName());

        // orElseGet은 값이 없을 때만 공급자 호출(지연 평가)
        User orElseGet1 = test.findUserOptional(1).orElseGet(OptionalTest::createGuest); // 호출 안 됨
        User orElseGet2 = test.findUserOptional(2).orElseGet(OptionalTest::createGuest); // 여기서만 호출됨
        System.out.println(orElseGet1.getName());
        System.out.println(orElseGet2.getName());

        printHeader("4. orElseThrow (명시적으로 예외 던지기)");
        try {
            User mustExist = test.findUserOptional(2)
                    .orElseThrow(() -> new NoSuchElementException("사용자를 찾을 수 없습니다."));
            System.out.println(mustExist.getName());
        } catch (NoSuchElementException e) {
            System.out.println("예외: " + e.getMessage());
        }

        printHeader("5. map / filter (값 변환, 조건 필터)");
        String nameOrGuest = test.findUserOptional(1)
                .map(User::getName)
                .orElse("guest");
        System.out.println(nameOrGuest); // dahee

        test.findUserOptional(1)
                .filter(u -> u.getName().startsWith("d"))
                .ifPresent(u -> System.out.println("d로 시작: " + u.getName()));
        test.findUserOptional(2)
                .filter(u -> u.getName().startsWith("d"))
                .ifPresent(u -> System.out.println("이 줄은 출력되지 않음"));

        printHeader("6. 절대 하지 말 것: get() 무방비 사용");
        // User user = test.findUserOptional(2).get(); // 비추천: 값이 없으면 NoSuchElementException 발생

        printHeader("마무리");
        System.out.println("Optional은 '값이 있을 수도/없을 수도'를 타입으로 표현하고, orElseGet/throw/map/filter 등으로 의도를 명확히 하세요.");
    }

    private static void printHeader(String title) {
        System.out.println("\n" + "=".repeat(8) + " " + title + " " + "=".repeat(8));
    }

    private static User createGuest() {
        System.out.println("[factory] guest 생성");
        return new User("guest");
    }
}
