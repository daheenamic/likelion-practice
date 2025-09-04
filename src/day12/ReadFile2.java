package day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 예외처리를 추가해보기
public class ReadFile2 {
    public static void main(String[] args) {

        // try 블럭 밖에서 close 하기 위해서 try 밖에 선언해야 된다
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("src/day12/IOExam1.java");
            fos = new FileOutputStream("src/day12/ioexam.txt");

            int n = 0;
            byte[] bytes = new byte[1024];

            while ((n = fis.read(bytes)) != -1) {
                String str = new String(bytes, 0, n);
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

            try {
                // 만들어지지 않은 상태로 닫으면 NPE가 발생되기 때문에 if 조건 걸어줘야 한다.
                if(fis != null) fis.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            // try 블럭 각각 써야 하는 이유 : 한번에 같이 쓰면 fis를 닫을 때 예외가 발생하면 fos 안 닫히기 때문..!
            try {
                if(fos != null) fos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            // 이렇게 try를 복잡하게 쓰지 않고
            // try-catch-resoure를 이용해 finally를 이용해서 close를 안해줘도 된다. -> ByteStreamExample.java
            // TODO 왜인지 찾아보기
        }
    }
}
