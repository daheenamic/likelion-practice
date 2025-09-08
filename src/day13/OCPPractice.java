package day13;

/*
public class PaymentProcessor {
    public void processPayment(String type, double amount) {
        if ("CREDIT_CARD".equals(type)) {
            // 신용카드 결제
        } else if ("PAYPAL".equals(type)) {
            // PayPal 결제
        }
        // 새로운 결제 방식 추가 시 여기를 수정해야 함
    }
}
*/

// 결제 방식 인터페이스
interface PaymentInterface{
    void processPayment(int price);
}

// 신용카드 결제 방식
class PayFromCreditCard implements PaymentInterface{
    @Override
    public void processPayment(int price) {
        // 신용카드 결제 로직
    }
}

// 카카오페이 결제 방식
class PayFromKakao implements PaymentInterface {
    @Override
    public void processPayment(int price) {
        // 카카오페이 결제 로직
    }
}

// 결제 처리
class ProcessPayment {
    private PaymentInterface service;



    public ProcessPayment(PaymentInterface service) {
        this.service = service;
    }

    public void processPayment (int price) {
        service.processPayment(price);
    }
}

public class OCPPractice {
    public static void main(String[] args) {
        ProcessPayment pp = new ProcessPayment(new PayFromKakao());
        pp.processPayment(3000);
    }
}
