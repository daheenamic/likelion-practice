package day08;

public class StringExam {
    public static void main(String[] args) {
        // String은 상속할 수 없다.
        // 보편적으로 객체를 생성하려면 new 연산자를 사용
        String str = new String();

        // 하지만 String은 아래처럼 문자열을 생성할 수 있다.
        String str2 = "abc";

        // 생성자에 parameter에 넣어서도 가능
        String str3 = new String("abc");

        // 다양한 메서드
        System.out.println(str2.charAt(0)); // a
        char c = str2.charAt(1);
        System.out.println(c); // b

        String str4 = "abc";

        // 이 경우에는 str3은 객체가 새로 생성되어 저장되었고, str2는 String Pool에 저장
        System.out.println(str2 == str3); // false

        // str2와 str4는 둘 다 String Pool에 저장되어 있기 때문에 true를 반환
        System.out.println(str2 == str4); // true

        String str1 = str4.concat("def");
        System.out.println(str4); // abc
        System.out.println(str1); // abcdef

        String str5 = " abc";
        String str6 = "abc";

        System.out.println(str5.equals(str6)); // false
        // trim()메서드를 이용하여 공백 제거
        System.out.println(str5.trim().equals(str6)); // true
    }
}
