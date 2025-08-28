package day07;

public class DatabaseConnection {
    // 1. private static 인스턴스
    private static DatabaseConnection instance;

    // 2. 생성자를 private으로 막아 외부에서 new 불가
    private DatabaseConnection() {
        String url = "jdbc:mysql://localhost:8080/mydb";
        String user = "lion";
        String password = "1234";

        // DB 연결하는 여러가지 코드들 ..

        System.out.println("데이터베이스 연결 생성");
    }

    // 3. public static으로 유일한 인스턴스를 반환하는 메서드
    public static DatabaseConnection getInstance() {
        if(instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("실행: " + query);
    }
}