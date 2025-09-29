package threadExam.practice02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTask implements Runnable{
    private final File inputFile;

    public FileReaderTask(String inputPath) {
        this.inputFile = new File(inputPath);
    }

    @Override
    public void run() {
        if (!inputFile.exists()) {
            System.out.println("[Reader] input.txt가 없습니다.");
            return;
        }

        System.out.println("[Reader] 파일 읽기 시작: " + inputFile.getAbsolutePath());

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))){
            String line;
            while((line = br.readLine()) != null) {
                System.out.println("[Reader] input.txt 읽는중: " + line);
                Thread.sleep(5000);
            }
            System.out.println("[Reader] 파일 읽기 완료");
        } catch (IOException e) {
            System.out.println("[Reader] 파일 읽기 실패: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
