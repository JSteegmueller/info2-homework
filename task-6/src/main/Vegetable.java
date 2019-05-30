package main;

public class Vegetable extends Food {
    private int cooked;
    private int cookingMinutes;

    public Vegetable(String name, int kCal, int cookingMinutes){
        super(name, kCal);
        edible = false;
        this.cookingMinutes = cookingMinutes;
        cooked = 0;
    }

    public void cookIt() {
        cooked++;
        if (cooked >= cookingMinutes) edible = true;
    }

    @Override
    public int prepare(int weight) {
        while (!edible){
            cookIt();
        }
        return weight;
    }
}
