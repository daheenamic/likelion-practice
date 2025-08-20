package day02;

public class PrintExam {
    public static void main(String[] args) {
        String name = "Jeong";
        int age = 35;

        System.out.println("println: 나의 이름은 " + name + "이고, 나이는 " + age + "세 입니다.");
        System.out.printf("printf: 나의 이름은 %s이고, 나이는 %d세 입니다.\n", name, age);

        System.out.println("이름: " + name);
        System.out.printf("이름: %s\n", name);
    }
}
