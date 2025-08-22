package day05;

public class StudentTest {
    public static void main(String[] args) {
        // static 메소드는 객체 생성 없이 호출 가능
        Student.displayStatistics();
        System.out.println("-----------");

        Student s1 = new Student("김철수", 85);
        Student s2 = new Student("이영희", 92);
        Student s3 = new Student("박민수", 78);

        // displayInfo()는 인스턴스메서드이므로 인스턴스화 해야 호출 가능
        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();
        System.out.println("-----------");

        // 클래스명으로 static 메서드 호출
        Student.displayStatistics();
    }
}
