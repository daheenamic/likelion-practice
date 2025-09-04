package day12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// TODO: InputStream, OutputStream, Reader, Writer 차이점

public class CharStreamExample {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("src/day12/input.txt");
             FileWriter writer = new FileWriter("src/day12/output.txt")) {

            int character;
            // 파일 끝(-1)까지 한 문자씩 읽기
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            System.out.println("텍스트 파일 복사 완료!");

        } catch (IOException e) {
            System.err.println("파일 처리 중 오류: " + e.getMessage());
        }
    }
}
