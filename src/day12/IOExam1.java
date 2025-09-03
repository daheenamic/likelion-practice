package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class IOExam1 {
    public static void main(String[] args) throws IOException {
        // 파일로부터 읽기
//        FileInputStream fis = new FileInputStream("input.txt");

        // 키보드 (System.in)로 부터 읽기
//        InputStream fis = System.in;

        // URL로부터 읽기
        URL url = new URL("https://www.naver.com/");
        InputStream fis = url.openStream();

        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String msg = null;
//        String msg = br.readLine(); // 첫번째줄
//        msg = br.readLine(); // 두번째줄
//        msg = br.readLine(); // 세번째줄

        // 전체를 다 읽고 싶을 때
        while ((msg = br.readLine()) != null) { // 읽을게 없을 때 까지 출력
            System.out.println(msg);
        }

        System.out.println(msg);
    }
}
