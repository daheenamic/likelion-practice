package day11;

public class ExceptionExam4 {
    public static void main(String[] args) {
        System.out.println("프로그램 시작");
        // 예외가 발생되지 않으면 catch 블럭은 실행되지 않는다.
        // 반드시 실행되어야 할 문장이 있다면? - finally
        String str = null;
        try {
            int i = Integer.parseInt(args[0]); // 항상 예외가 일어나는 것은 아님
            System.out.println(10/i);
            // try 블럭에서도 예외가 발생되면, 발생된 지점부터 나머지 try 블럭 안의 문장은 실행되지 않음.
            System.out.println(str.charAt(0));
            System.out.println("try 블럭에서 하는 다음 일");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception 블럭 실행");
            System.out.println("e");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException 블럭 실행");
            System.out.println(e);
        } finally {
            // 예외가 발생/미발생, 처리/미처리 상황에서도 항상 실행 된다.
            // 어딘가에 연결 되었을때 접속을 종료 해 주는것이 좋다. 예) scanner.close();
            System.out.println("finally 블럭 실행");
        }

        // 예외가 발생되었다면 적절히 처리해야지만 실행이 됨.
        System.out.println("프로그램 종료");
    }
}
