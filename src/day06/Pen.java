package day06;

public class Pen {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        Pen p = new Pen();
//        p.color = "red"; // 권장되지 않음
        p.setColor("red");
    }
}
