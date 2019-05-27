package main;

public class Dishwasher {

    private static Dish[] dishes;
    private static Dish[] inMachine;
    private static final int maxCapacity = 20;
    private static int capacity;

    public static void main(String[] args) {
        dishes = new Dish[10];
        inMachine = new Dish[10];
        capacity = 0;

        dishes[0] = new Dish("Cutlery", 0.1f);
        dishes[1] = new Dish("Cutlery", 0.1f);
        dishes[2] = new Dish("Plate", 0.6f);
        dishes[3] = new Dish("Plate", 0.2f);
        dishes[4] = new Dish("Cup", 0.2f);
        dishes[5] = new Dish("Cup", 0.8f);
        dishes[6] = new Dish("Plate", 0.1f);
        dishes[7] = new Dish("Pot", 0.9f);
        dishes[8] = new Dish("Pot", 0.4f);
        dishes[9] = new Dish("Plate", 0.4f);

        int idx = 0;
        while (idx < dishes.length && capacity + dishes[idx].getSize() <= maxCapacity) {
            inMachine[idx] = dishes[idx];
            capacity += dishes[idx].getSize();
            idx++;
        }

        for (int i = 0 ; i < idx ; i++){
            inMachine[i].clean(0.3f);
            inMachine[i].printStatus();
        }
    }
}
