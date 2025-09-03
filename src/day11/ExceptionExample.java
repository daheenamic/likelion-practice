package day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionExample {

    // 파일 읽는 메서드: IOException 발생 가능 → throws로 선언
    public static String readFile(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        return br.readLine(); // 첫 줄 읽기
    }

    public static void main(String[] args) {
        try {
            // 입력값 검증: 파일 경로가 들어오지 않았을 때 throw로 예외 발생
            if (args.length == 0) {
                throw new IllegalArgumentException("파일 경로를 입력해야 합니다.");
            }

            String line = readFile(args[0]);
            // readFile 호출: IOException은 throws로 전파됨
            System.out.println("첫 줄: " + line);

        } catch (IllegalArgumentException e) {
            // 파일 경로는 들어왔으나 잘못된 값이 들어옴
            System.out.println("잘못된 인자: " + e.getMessage());
        } catch (IOException e) {
            // 파일 경로도 들어왔고, 값도 제대로 들어왔으나 파일이 없는 경우, 읽기 실패 처리
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}
