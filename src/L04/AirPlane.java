package L04;


interface IAir{
   default void  back(){
       System.out.println("back");

    }
    void left();
    void right();

}

interface I1{
    static int i = 7;
}
interface I2{}
interface I3{}
interface I4{}
public class AirPlane implements IAir,I1,I2,I3,I4 {

    public static void main(String[] args) {
    }


    @Override
    public void left() {

    }

    @Override
    public void right() {

    }
}

class TestAit{

    public static void main(String[] args) {
        IAir air  = new AirPlane();
    }
}
