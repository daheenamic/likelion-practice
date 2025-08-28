package day07;

// 사용 예제
public class SingletonTest {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance(); // "데이터베이스 연결 생성"
        DatabaseConnection db2 = DatabaseConnection.getInstance(); // 이미 생성된 걸 반환

        db1.executeQuery("SELECT id, name, age FROM users");
    }
}