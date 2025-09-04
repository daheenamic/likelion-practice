package day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class IOExam2 {
    // 사용자의 정보(이름, 전화번호, 주소)를 입력받아서 파일에 저장하는 메서드
    public static void userInfoInput(String path) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(new FileWriter(path));
        ) {
            System.out.print("이름: ");
            String name = reader.readLine();

            System.out.print("전화번호: ");
            String number = reader.readLine();

            System.out.print("주소: ");
            String address = reader.readLine();

            writer.println("이름: " + name);
            writer.println("전화번호: " + number);
            writer.println("주소: " + address);

            System.out.println("사용자의 파일이 생성되었습니다.");
            System.out.println("================================");

        } catch (IOException e) {
            System.err.println("입력 오류: " + e.getMessage());
        }
    }

    // 파일로부터 읽어와서 사용자의 정보를 출력하는 메서드
    public static void userInfoOutput(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path));) {
            System.out.println("사용자의 정보를 출력 합니다.");

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("출력 오류: " + e.getMessage());
        }
    }

    // n건 정도를 입력 받아서 Collection에 저장하는 메서드
    public static void userInfoSave(String path) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("저장 할 사용자의 수: ");
            int pNum = Integer.parseInt(reader.readLine());

            List<Person> personList = new ArrayList<>();

            for (int i = 0; i < pNum; i++) {
                System.out.println((i + 1) + "번째 사용자를 입력하세요.");

                System.out.print("이름: ");
                String name = reader.readLine();

                System.out.print("전화번호: ");
                String number = reader.readLine();

                System.out.print("주소: ");
                String address = reader.readLine();

                Person person = new Person(name, number, address);
                personList.add(person);
            }

            outputFromCollection(personList, path);

        } catch (IOException e) {
            System.out.println("입력 오류: " + e.getMessage());
        }
    }

    // Collection의 내용을 파일에 저장하는 메서드
    public static void outputFromCollection(List<Person> personList, String path) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            int idx = 1;
            for (Person p : personList) {
                writer.println("== " + idx++ + "번째 사용자의 정보 ==");
                writer.println("이름: " + p.getName());
                writer.println("번호: " + p.getNumber());
                writer.println("주소: " + p.getAddress());
                writer.println();
            }
            System.out.println("여러명의 사용자 저장 완료: " + path);

        } catch (IOException e) {
            System.out.println("출력 오류: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String path = "src/day12/userInfo.txt";
        userInfoInput(path);
        userInfoOutput(path);
        userInfoSave(path);
    }
}