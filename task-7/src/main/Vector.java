package main;

public class Vector {
    public int x,
            y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Vector v){
        return (x == v.x && y == v.y);
    }
}
