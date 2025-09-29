package lambdaExam;

// 1. 인터페이스를 구현해서 class로 만듦
class FuncImpl implements FuncTest {
    @Override
    public void run() {
        System.out.println("1. 클래스를 독립적으로 만들어서 구현");
    }
}

public class FuncImplTest {
    public static void main(String[] args) {
        // 2. 인터페이스를 구현한 익명 객체 생성
        FuncTest funcTest = new FuncTest() {
            @Override
            public void run() {
                System.out.println("2. 함수적 인터페이스 구현");
            }
        };

        // 3. 람다식을 이용해서 구현
        FuncTest funcTest2 = () -> {
            System.out.println("3. 람다식을 이용해서 인터페이스 구현");
        };

        FuncImpl funcImpl = new FuncImpl();
        funcImpl.run();

        funcTest.run();
        funcTest2.run();
    }
}


