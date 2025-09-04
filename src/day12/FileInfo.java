package day12;

import java.io.File;
import java.io.IOException;

public class FileInfo {
    public static void main(String[] args) {
        if(args.length != 1) { // 인자 1로 설정하고 실행
            System.out.println("사용법 : java FileInfo 파일이름");
            System.exit(0);
        }

        File f = new File("src/day12/myInfo.txt");
        if(f.exists()) { // 파일이 존재할 경우
            System.out.println("length : " + f.length()); // 56
            System.out.println("canRead : " + f.canRead()); // true
            System.out.println("canWrite : " + f.canWrite()); // true
            System.out.println("getAbsolutePath : " + f.getAbsolutePath()); // 단순한 절대경로
            // /Users/jeongdahee/dev/likelion/likelion-practice/src/day12/myInfo.txt
            try {
                System.out.println("getCanonicalPath : " + f.getCanonicalPath()); // 조금 더 정확한 위치
                // /Users/jeongdahee/dev/likelion/likelion-practice/src/day12/myInfo.txt
            } catch(IOException e) {
                System.out.println(e);
            }
            System.out.println("getName : " + f.getName()); // myInfo.txt
            System.out.println("getParent : " + f.getParent()); // src/day12
            System.out.println("getPath : " + f.getPath()); // src/day12/myInfo.txt
        } else { // 파일이 존재하지 않을 경우
            System.out.println("파일이 존재하지 않습니다.");
        }
    }
}