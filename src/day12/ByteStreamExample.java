package day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {
        // try-with-resources를 사용한 자동 리소스 관리
        try (FileInputStream in = new FileInputStream("src/day12/IOExam1.java"); // 이 파일을
             FileOutputStream out = new FileOutputStream("src/day12/output.text")) { // 여기에 복사하고 싶다

            int byteData;
            // 파일 끝(-1)까지 한 바이트씩 읽기
            while ((byteData = in.read()) != -1) {
                out.write(byteData);
            }
            System.out.println("파일 복사 완료!");

        } catch (IOException e) {
            System.err.println("파일 처리 중 오류: " + e.getMessage());
        }
    }
}