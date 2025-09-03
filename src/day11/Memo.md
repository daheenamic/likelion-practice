# 📌 try-catch, throw, throws 차이 정리

---

## try-catch
- 예외를 직접 잡아서 처리 (handling)
- 메서드 안
- 예외 발생해도 프로그램이 죽지 않고 계속 실행

```java
try {
    int x = 10 / 0;   // ArithmeticException 발생
} catch (ArithmeticException e) {
    System.out.println("0으로 나눌 수 없습니다!");
}
```

## throw
- 예외 객체를 직접 발생 지점에 던짐
- 메서드 안
- 예외를 강제로 발생시킴

```java
if (score < 0 || score > 100) {
    throw new IllegalArgumentException("점수는 0~100 사이여야 합니다.");
}
```

## throws
- "이 메서드에서 예외가 발생할 수 있으니, 호출자가 처리해라" -> 예외 선언/위임
- 메서드 선언부
- 메서드 안에서 처리하지 않고 호출자에게 책임 전가

```java
public void readFile() throws IOException {
    FileReader fr = new FileReader("a.txt");  // IOException 발생 가능
}
```

***

```java
import java.io.*;

// 파일을 읽는 기능
public class ExceptionExample {

    // 파일 읽는 메서드: IOException 발생 가능 → throws로 선언
    public static String readFile(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        return br.readLine(); // 첫 줄 읽기
    }

    public static void main(String[] args) {
        try {
            // 입력값 검증: 잘못된 값이 들어오면 throw로 예외 발생
            if (args.length == 0) {
                throw new IllegalArgumentException("파일 경로를 입력해야 합니다.");
            }

            // readFile 호출: IOException은 throws로 전파됨
            String line = readFile(args[0]);
            System.out.println("첫 줄: " + line);

        } catch (IllegalArgumentException e) {
            // 잘못된 입력값 처리
            System.out.println("잘못된 인자: " + e.getMessage());
        } catch (IOException e) {
            // 파일이 없는 경우, 읽기 실패 처리
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}
```