package L04;

import java.awt.*;

interface Point3DInterface {

    double distance(Point3D p); // distance from other point p.

    Boolean equals(Point3D p); // returns true if two points are equal

    String toString();
}

public class Point3D implements Point3DInterface {

    private double _x;
    private double _y;
    private double _z;

    public Point3D() {

        this._x = 0;
        this._y = 0;
        this._z = 0;
    }

    public Point3D(double _x, double _y, double _z) {

        this._x = _x;
        this._y = _y;
        this._z = _z;
    }

    public Point3D(Point3D p) {
        this._x = p._x;
        this._y = p._y;
        this._z = p._z;
    }


    @Override
    public double distance(Point3D p) {
        double xPow = Math.pow((p._x - _x), 2);
        double yPow = Math.pow((p._y - _y), 2);
        double zPow = Math.pow((p._z - _z), 2);
        return Math.sqrt(xPow + yPow + zPow);
    }

    @Override
    public Boolean equals(Point3D p) {
        return p._x == _x && p._y == _y && p._z == _z;
    }

    @Override
    public String toString() {
        return "";
    }
}

class PointTest {

    public static void main(String[] args) {
        Point3D p3 = new Point3D(null);

        Point p1;

    }
}
