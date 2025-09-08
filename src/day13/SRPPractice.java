package day13;

/*

// 다음 코드를 SRP 원칙에 맞게 리팩토링하세요.
public class Employee {
    private String name;
    private double salary;

    // 직원 정보 관리 + 급여 계산 + 데이터베이스 저장을 모두 담당
    public double calculatePay() {
        // 급여 계산 로직
    }

    public void saveToDatabase() {
        // DB 저장 로직
    }

    public String generateReport() {
        // 보고서 생성 로직
    }
}

*/

// 직원 정보 관리
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

// 급여계산
class PayCalculator{
    public double payCalculate(Employee emp) {
        int total = 0;
        // 급여 계산 로직
        return total;
    }
}

// DB 저장
class Store {
    public void save(Employee emp) {
        // DB 저장 로직
    }
}

// 보고서 생성
class MakeReport{
    public void makeReport(Employee emp) {
        // 보고서 생성 로직
    }
}

public class SRPPractice {
    public static void main(String[] args) {
        // 직원 생성
        Employee emp = new Employee("Jeong", 300);

        // 직원의 급여 계산
        PayCalculator pc = new PayCalculator();
        double pay = pc.payCalculate(emp);

        // 직원 정보 저장
        Store store = new Store();
        store.save(emp);

        // 보고서 생성
        MakeReport mr = new MakeReport();
        mr.makeReport(emp);
    }
}
