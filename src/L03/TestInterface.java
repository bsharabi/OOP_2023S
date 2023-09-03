package L03;

public class TestInterface {

    public static void main(String[] args) {
        G g = new G();
        H h = new H();
        I i = new I();
        J j = new J();

        AirPlan a1 = new G();
        AirPlan a2 = new H();
        AirPlan a3 = new I();
        AirPlan a4 = new J();


//        IAir i1 = new G();
        IAir i2 = new H();
        IAir i3 = new I();
        IAir i4 = new J();

        go(i2);
        go(i3);
        go(i4);




    }

    private static void go(IAir i) {

        i.back();


    }
}

interface IA {

    void func();

    void func1();

}

class A implements IA {


    @Override
    public void func() {

    }

    @Override
    public void func1() {

    }
}


interface IAir {
   default void back(){
        System.out.println("back from IAir");
    }

    static void func(){

    }
    void right();

    void left();

    void forward();

}

class AirPlan implements IAir {

    void air() {

    }

    @Override
    public void back() {

    }

    @Override
    public void right() {

    }

    @Override
    public void left() {

    }

    @Override
    public void forward() {

    }
}


class G extends AirPlan {
    void g() {

    }
//
//    void back() {
//
//    }
//
//    void right() {
//
//    }
//
//    void left() {
//
//    }
//
//    void forward() {
//
//    }

}

class H extends AirPlan implements IAir {

    void h() {

    }


    @Override
    public void right() {

    }

    @Override
    public void left() {

    }

    @Override
    public void forward() {

    }


}

class I extends AirPlan implements IAir {

    void i() {

    }

    @Override
    public void back() {
            System.out.println("back from I");

    }

    @Override
    public void right() {

    }

    @Override
    public void left() {

    }

    @Override
    public void forward() {

    }

}

class J extends AirPlan implements IAir {


    void j() {

    }

    @Override
    public void back() {

    }

    @Override
    public void right() {

    }

    @Override
    public void left() {

    }

    @Override
    public void forward() {

    }

}