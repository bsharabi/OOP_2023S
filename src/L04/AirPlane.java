package L04;


import java.awt.*;

interface IAir{
    void  back();
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

    public void back(){

    }
}

class TestAit{

    public static void main(String[] args) {
        Point p = new Point(5,5);
        IAir air  = new AirPlane();
    }
}
