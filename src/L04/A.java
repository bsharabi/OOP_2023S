package L04;

public class A {

    private String name;
    private B b;

    protected String lastName;

   final String str;


    public B getB() {
        return new B(b);
    }

    public void setB(B b) {
        this.b = b;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2)
            this.name = name;
    }

    public A(String name) {
        setName(name);
        str="";
    }
}
class B {


    public B(B b){}
}

class TestA {


    public static void main(String[] args) {
        A a = new A("");

    }
}
