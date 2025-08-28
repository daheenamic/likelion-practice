package day07;

public class ABClass implements AInter, BInter{

    // 구현부가 중요하지 뭘 구현해놨는지는 중요하지 않다. Interfaces는 구현부가 없으니까 !

    @Override
    public void aMethod() {

    }

    @Override
    public void bMethod() {

    }

    public static void main(String[] args) {
        ABClass abClass = new ABClass();
        // 어차피 구현부 없어서 어떤거 갖다 써도 헷갈릴 일이 없다.
        abClass.aMethod();
        abClass.bMethod();
    }
}
