package day08;

import java.util.Objects;

public class Pen {
    String color;
    int length;
    int price;

    public Pen() {
        this(null, 0, 0);
    }
    public Pen(String color, int length) {
        this(color, length, 0);
    }
    public Pen(String color, int length, int price) {
        this.color = color;
        this.length = length;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pen = { 색상: " + color + ", 길이: " + length + "cm, 가격: " + price + "원 }";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return length == pen.length && Objects.equals(color, pen.color) && Objects.equals(price, pen.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, length, price);
    }

    public static void main(String[] args) {
        Pen pen1 = new Pen();
        pen1.setColor("blue");
        pen1.setLength(8);
        pen1.setPrice(2000);

        Pen pen2 = new Pen("black", 10);
        pen2.setPrice(1500);

        Pen pen3 = new Pen("red", 12,1000 );

        System.out.println(pen1); // Pen = { 색상: blue, 길이: 8cm, 가격: 2000원 }
        System.out.println(pen2); // Pen = { 색상: black, 길이: 10cm, 가격: 1500원 }
        System.out.println(pen3); // Pen = { 색상: red, 길이: 12cm, 가격: 1000원 }

        Pen pen4 = new Pen();
        System.out.println(pen4); // Pen = { 색상: null, 길이: 0cm, 가격: 0원 }
    }
}
