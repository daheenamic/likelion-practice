package streamExam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

class Student2 {
    private String name;
    private int age;
    private int score;

    public Student2(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }
}

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

class Temperature {
    private String city;
    private int maxTemp;

    public Temperature(String city, int maxTemp) {
        this.city = city;
        this.maxTemp = maxTemp;
    }

    public String getCity() {
        return city;
    }

    public int getMaxTemp() {
        return maxTemp;
    }
}

public class StreamPractice01 {
    public static void main(String[] args) {

        // 1. 주어진 정수 배열에서 짝수만을 찾아 그 합을 구하시오.
        int[] numbers = {3, 10, 4, 17, 6};
        int sum = Arrays.stream(numbers).filter(n -> n % 2 == 0).sum();
        System.out.println("1. 짝수의 합: " + sum);
        System.out.println("=".repeat(20));

        // 2. 주어진 문자열 리스트에서 길이가 5 이상인 문자열만을 선택하여 대문자로 변환하고, 결과를 리스트로 반환하시오.
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> words2 = words.stream()
                .filter(w -> w.length() >= 5)
                .map(String::toUpperCase)
                .toList();
        System.out.println("2. 대문자 변환 후 배열: " + words2);
        System.out.println("=".repeat(20));

        // 3. 학생 객체의 리스트가 주어졌을 때, 성적(score)이 80점 이상인 학생들만을 선택하고, 이들의 이름을 알파벳 순으로 정렬하여 출력하시오.
        List<Student> students = Arrays.asList(
                new Student("Alice", 82),
                new Student("Bob", 90),
                new Student("Charlie", 72),
                new Student("David", 76)
        );

        List <String> studentsArr = students.stream()
                .filter(s -> s.getScore() >= 80)
                .map(Student::getName)
                .sorted()
                .toList();
        System.out.println("3. 80점 이상의 학생을 알파벳 순으로: " + studentsArr);
        System.out.println("=".repeat(20));

        // 4. 직원 객체의 리스트에서 각 부서(department)별로 평균 급여를 계산하시오.
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "HR", 2000),
                new Employee("Charlie", "Engineering", 5000),
                new Employee("David", "Engineering", 4000)
        );

        Map<String, Double> avgByDept = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
        ));

        System.out.println("4. 부서별 평균 급여 ");

        avgByDept.forEach((dept, avg) -> {
            System.out.println(dept + ": " + avg);
        });

        System.out.println("=".repeat(20));

        // 5. 주어진 제품 리스트에서 각 카테고리별로 평균 가격을 계산하시오.
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Smartphone", "Electronics", 700.00),
                new Product("Desk", "Furniture", 300.00),
                new Product("Chair", "Furniture", 150.00)
        );

        Map<String, Double> avgByCategory = products.stream().collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.averagingDouble(Product::getPrice)
        ));

        System.out.println("5. 카테고리별 평균 가격");

        avgByCategory.forEach((category, avg) -> {
            System.out.println(category + ": " + avg);
        });

        System.out.println("=".repeat(20));

        // 6. 학생 리스트에서 나이대별(10대, 20대 등)로 평균 점수를 계산하시오.
        List<Student2> students2 = Arrays.asList(
                new Student2("Alice", 14, 88),
                new Student2("Bob", 23, 82),
                new Student2("Charlie", 17, 95),
                new Student2("David", 21, 73)
        );

        Map<Integer, Double> avgByAge = students2.stream().collect(Collectors.groupingBy(
                s -> s.getAge() / 10 * 10,
                TreeMap::new, // 키 기준 오름차순 정렬
                Collectors.averagingInt(Student2::getScore)
        ));

        System.out.println("6. 나이대별 평균 점수");

        avgByAge.forEach((age, avg) -> {
            System.out.println(age + "대: " + avg + "점");
        });

        System.out.println("=".repeat(20));

        // 7. 여러 도시의 일일 최고 온도가 주어졌을 때, 각 도시의 최고 온도를 찾으시오.
        List<Temperature> temperatures = Arrays.asList(
                new Temperature("Seoul", 33),
                new Temperature("New York", 30),
                new Temperature("Seoul", 34),
                new Temperature("New York", 28)
        );

        Map<String, Integer> maxTemp = temperatures.stream().collect(Collectors.toMap(
                Temperature::getCity,
                Temperature::getMaxTemp,
                Integer::max // 같은 키가 충돌 시, 더 큰 값을 선택
        ));

        System.out.println("7. 각 도시의 최고온도");

        maxTemp.forEach((city, temp) -> {
            System.out.println(city + ": " + temp + "도");
        });
    }
}
