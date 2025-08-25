package day06;

class Animal {
    public void makeSound() {
        System.out.println("동물이 소리를 냅니다.");
    }

    public void move() {
        System.out.println("동물이 움직입니다.");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("강아지가 네발로 뛰어 다닌다.");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("야옹");
    }

    @Override
    public void move() {
        System.out.println("고양이가 살금살금 걷는다.");
    }
}

public class OverrideExam {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();

        Cat cat = new Cat();
        cat.makeSound();

        // 자식 클래스에서 메서드를 재정의 하는데 Animal이 꼭 필요한가?
        Animal animal = null;

        // 만약에 이런식의 분기 처리를 한다면
        if ("1".equals(args[0])) {
            animal = new Cat();
        } else {
            animal = new Dog();
        }
        // Animal 타입 참조 하나만 가지고도, 실행 시점에 다른 자식 객체를 주입하면 결과가 달라진다
        animal.makeSound();
        animal.move();
    }
}
