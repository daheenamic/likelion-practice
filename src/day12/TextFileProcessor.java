package day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// 텍스트 파일 처리 예제 (문자단위)
public class TextFileProcessor {
    public static void main(String[] args) {
        String inputFile = "src/day12/myInfo.txt";
        String outputFile = "src/day12/myInfo2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            String line;
            int lineNumber = 1;

            // 한 줄씩 읽어서 처리
            // read()  → byte 단위로 읽음 → EOF는 -1 반환
            // readLine() → 문자열(한 줄) 단위로 읽음 → EOF는 null 반환
            while ((line = reader.readLine()) != null) {
                // 줄 번호 추가하여 쓰기
                writer.println(lineNumber + ": " + line);
                lineNumber++;
            }

            System.out.println("텍스트 파일 처리 완료!");
            System.out.println("총 " + (lineNumber - 1) + "줄 처리됨");

        } catch (IOException e) {
            System.err.println("파일 처리 오류: " + e.getMessage());
        }
    }
}
