package day10;

public class ObjectBoxMain {
    public static void main(String args[]) {
        ObjectBox box = new ObjectBox();
        box.set("kim");
        String str = (String)box.get(); // 형변환 필요
        System.out.println(str.toUpperCase());

        Integer v = 5;
        box.set(v);
        Integer i = (Integer)box.get(); // 형변환 필요
        System.out.println(i.intValue());
    }
}
