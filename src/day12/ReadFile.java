package day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadFile {
    // 메인에 throws Exception 하는건 권장되지 않지만, 간단하게 테스트 할 때 사용하면 된다.
    public static void main(String[] args) throws Exception {
        // 파일에서 읽어와서 파일에 쓰기
        // Stream은 단방향으로 데이터가 흐른다.
        FileInputStream fis = new FileInputStream("src/day12/IOExam1.java");
        FileOutputStream fos = new FileOutputStream("src/day12/ioexam.txt");

        System.out.println(fis.read()); // 112 (p의 아스키코드값)
        System.out.println((char)fis.read()); // a
        System.out.println((char)fis.read()); // c - 한글자가 읽음, 한 번 읽으면 다음번엔 읽지 않고 다음 글자를 읽음

        // 전부 읽고 싶으면 계속 반복해서 읽어야 됨
        // fis.read() 했을 때 결과가 끝이면 -1을 return함. EOF(End Of File)
        int n = 0;
        int count = 0;
        while ((n = fis.read()) != -1) {
            System.out.print((char)n);
            fos.write(n); // 실제로 파일은 Java가 아닌 운영체제(os)가 써줌
            count++;
        }

        System.out.println("Count: " + count); // 1071번이나 써야됨
        // 운영체제는 운영체제 나름의 스케줄링이 있기 때문에 1071번을 계속 쓰지 않음.
        // 운영체제만의 최적의 스케줄을 갖고있다가 버퍼가 가득찼거나, 다 썼을때 내보냄.

        System.out.println("==============================================");

        byte[] bytes = new byte[1024]; // TODO: 1024를 쓰는이유 찾아보기

        count = 0;
        // 이렇게 하면 위에서 설정한 byte 배열 만큼만 읽는다
        while ((n = fis.read(bytes)) != -1) {
            String str = new String(bytes, 0, n); // TODO: 중복으로 읽히는 이유 찾아보기
            System.out.println(str); // 그냥 실행하면 출력되지 않음. 위에서 이미 다 읽었기 때문. 출력하기 위에서는 위의 while문 주석처리
            count++;
        }

        System.out.println("Count: " + count); // 2번만에 씀

        // TODO 콘솔창에 배열로 담지 않고 char로 출력하면 한글이 깨지는이유? byte 배열은 안깨짐.. 찾아보기

        // close를 안하면 운영체제가 계속 기다리다가 그냥 끝나버릴 수 있음.
        // 기다리는 운영체제에게 더이상 없다고 신호를 보내는 것
        // 그래서 예외처리를 하게 되면 finally에 이런 close()들을 넣어줘야 한다.
        fis.close();
        fos.close();
    }
}
