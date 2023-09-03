package L02.inheritance;

public class Car {

    String type;
    String color;
    Engine engine;


    public Car(String type, String color) {
        this.type = type;
        this.color = color;
        //100fff
        engine= new Engine("aum",180);
    }

    public Car(Car other) {
        this.type = other.type;
        this.color = other.color;
        this.engine=  new Engine(other.engine);
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}'+super.toString()+"\n";
    }
}

class Engine{
    String type;
    int hp;

    public Engine(String type, int hp) {
        this.type = type;
        this.hp = hp;
    }
    public Engine(Engine other) {
        this.type = other.type;
        this.hp = other.hp;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                ", hp=" + hp +
                '}';
    }
}

class Test2{

    public static void main(String[] args) {
        Car audi = new Car("Audi","Black");
        System.out.println(audi);
        Car audiVersion2 = new Car(audi);

        System.out.println(audiVersion2);

        audi.engine.hp=890;
        System.out.println(audi);
        System.out.println(audiVersion2);
    }
}
