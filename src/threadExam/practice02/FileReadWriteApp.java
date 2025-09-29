package threadExam.practice02;

public class FileReadWriteApp {
    public static void main(String[] args) throws InterruptedException {
        String inputPath = "src/threadExam/practice02/input.txt";
        String outputPath = "src/threadExam/practice02/output.txt";

        Thread reader = new Thread(new FileReaderTask(inputPath), "reader-thread");
        Thread writer = new Thread(new FileWriterTask(outputPath), "writer-thread");

        System.out.println("[Main] 메인 시작");

        reader.start();
        writer.start();

        reader.join();
        writer.join();

        System.out.println("[Main] 메인 종료");
    }
}
