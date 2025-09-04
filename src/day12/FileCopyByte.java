package day12;

import java.io.*;

// 파일 복사 예제
public class FileCopyByte {
    public static void main(String[] args) {
        String sourceFile = "src/day12/myInfo.txt";
        String destFile = "src/day12/myInfoCopy.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile);
             BufferedInputStream bis = new BufferedInputStream(fis);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            // 버퍼 단위로 읽고 쓰기
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("파일 복사 완료: " + sourceFile + " → " + destFile);

        } catch (IOException e) {
            System.err.println("파일 복사 실패: " + e.getMessage());
        }
    }
}
