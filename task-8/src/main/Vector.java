package main;

public class Vector {
    public double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector rotated(double alpha) {
        return new Vector(x * Math.cos(alpha) - y * Math.sin(alpha), x * Math.sin(alpha) + y * Math.cos(alpha));
    }

    public Vector added(Vector v) {
        return new Vector(x + v.x, y + v.y);
    }

    public Vector scaled(double s) {
        return new Vector(x * s, y * s);
    }

    @Override
    public String toString() {
        return super.toString() + " " + x + ":" + y;
    }
}
