package main;

public class Dishwasher {

    private static Dish[] dishes;
    private static Dish[] myDishwasher;
    private static final int maxCapacity = 20;
    private static int capacity;

    public static void main(String[] args) {
        dishes = new Dish[10];
        myDishwasher = new Dish[10];
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
        int idxMyDiashwasher = 0;
        while (idx < dishes.length) {
            if (capacity + dishes[idx].getSize() > maxCapacity){
                idx++;
                continue;
            }
            myDishwasher[idxMyDiashwasher] = dishes[idx];
            capacity += dishes[idx].getSize();
            idx++;
            idxMyDiashwasher++;
        }

        for (int i = 0 ; i < idxMyDiashwasher ; i++){
            myDishwasher[i].clean(0.3f);
            myDishwasher[i].printStatus();
        }
    }
}
