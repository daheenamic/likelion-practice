package threadExam.practice02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTask implements Runnable{
    private final File outputFile;
    private final String exitKeyword;

    public FileWriterTask(String outputPath) {
        this(outputPath,"exit");
    }

    public FileWriterTask(String outputPath, String exitKeyword) {
        this.outputFile = new File(outputPath);
        this.exitKeyword = exitKeyword;
    }

    @Override
    public void run() {
        System.out.println("[Writer] 파일 쓰기 시작: " + outputFile.getAbsolutePath());
        System.out.println("[Writer] 콘솔에 입력하세요. 종료하려면 \"" + exitKeyword + "\" 입력");

        Scanner sc = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))){
            while (true) {
                if (!sc.hasNextLine()) {
                    System.out.println("[Writer] 입력 종료 (EOF)");
                    break;
                }
                String line = sc.nextLine();
                if (line.equals(exitKeyword)) {
                    System.out.println("[Writer] 입력 종료 (종료 키워드 입력)");
                    break;
                }
                bw.write(line);
                bw.newLine();
                bw.flush();
                System.out.println("[Writer] 기록 완료");
            }
            System.out.println("[Writer] 파일 쓰기 완료");
        } catch (IOException e) {
            System.out.println("[Writer] 파일 쓰기 실패: " + e.getMessage());
        }
    }
}
