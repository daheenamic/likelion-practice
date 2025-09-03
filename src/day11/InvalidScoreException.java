package day11;

// Exception을 extends 받으면 예외 객체가 된다.
public class InvalidScoreException extends RuntimeException {

    // 예외 클래스에 생성자로 메세지를 추가 할 수 있다.
    public InvalidScoreException() {
        super("[생성자에 메세지를 추가] 점수는 0~100 사이만 입력 가능 합니다.");
    }

    // 메세지를 받아서 생성 할 수 있도록 생성자를 추가
    public InvalidScoreException(String message) {
        super(message);
    }

}
