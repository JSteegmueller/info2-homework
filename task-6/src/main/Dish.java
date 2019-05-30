package main;

public class Dish {
    public float dirty;
    public float dirtReduction;
    protected int size;

    public Dish(float dirty){
        this.dirty = dirty;
        dirtReduction = 0.3f;
    }

    public void printStatus() {
        System.out.println("Name: " + this.getClass().getSimpleName());
        System.out.println(dirty);
        System.out.println((dirty <= 0.1) ? "is clean" : "still dirty");
        System.out.println();
    }

    public void clean() {
        dirty -= dirtReduction;
        if (dirty < 0) dirty = 0;
    }

    public int getSize() {
        return size;
    }
}
