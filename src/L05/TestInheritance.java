package L05;

public class TestInheritance {


    public static void main(String[] args) {
        B b = new B();
        A ba = new B();
        A aa = new A();
        aa.what();

        b.what();
        ba.what();



    }


}


class A {
    public int a;
    public int a1;

    public void what() {
        System.out.println("What what");
    }
}

class B extends A {

    public void func() {

        System.out.println("func");
    }
    public void what() {
        System.out.println("What what what WTF");
    }
}
