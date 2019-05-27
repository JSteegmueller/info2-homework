package main;

public class Vegetable {
    public String name;
    public int kcal;
    private boolean edible;
    private int cookingMinutes;
    private int cooked;

    public Vegetable(String name, int kcal, int cookingMinutes) {
        edible = false;
        cooked = 0;

        this.name = name;
        this.kcal = kcal;
        this.cookingMinutes = cookingMinutes;
    }

    public boolean isEdible() {
        return edible;
    }

    public void cookIt() {
        cooked++;
        if (cooked >= cookingMinutes) edible = true;
    }

    public float computeCalories(float gramms) {
        // TODO 5.1 b) Fruits with peal contribute only 90% of their mass to the kcal.
        return (edible) ? (kcal / 100.0f) * gramms : 0;
    }


}
