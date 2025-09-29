package lambdaExam;

public class PlusFunctionExam {
    public static void main(String[] args) {
        // 기본 람다식
        PlusFunction plusObj = (int i, int j) -> {
            return i + j;
        };
        int value = plusObj.plus(100, 200);
        System.out.println(value); // 300

        // 타입 추론 활용
        PlusFunction plusObj2 = (i, j) -> {
            return i + j;
        };
        int value2 = plusObj.plus(100, 200);
        System.out.println(value2); // 300

        // 축양형 람다식
        PlusFunction plusObj3 = (i, j) -> i + j;
        int value3 = plusObj.plus(100, 200);
        System.out.println(value3); // 300
    }
}
