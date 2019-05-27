package main;

public class Meal {

    // TODO 5.1 a) kcalSum
    private float kcalSum;

    // TODO 5.1 j) ingredients, amounts
    // - Think about how to keep track of how many ingredients were added!
    private String[] ingredients;
    private int[] amounts;
    private int index;

    public Meal() {
        // TODO a) initialize
        kcalSum = 0f;
        ingredients = new String[100];
        amounts = new int[100];
        index = 0;
    }

    public void addFruit(Fruit fruit, int weight) {
        //TODO 5.1 a) Remove this comment after creating the attribute kcalSum.
        kcalSum += fruit.computeCalories(weight);
        // TODO 5.1j) Add information to ingredients and amounts.
        ingredients[index] = fruit.name;
        amounts[index] = weight;
        index++;
    }

    //TODO 5.1 c) Remove this comment after implementing the Vegetable class.
    public void addVegetable(Vegetable vegetable, int gVegetable) {
        kcalSum += vegetable.computeCalories(gVegetable);
        // TODO 5.1j) Add information to ingredients and amounts.
        ingredients[index] = vegetable.name;
        amounts[index] = gVegetable;
        index++;
    }


    public void printStatus() {

        // TODO 5.1 a) Remove this comment after creating the attribute kcalSum.
        System.out.println("Your meal has: " + kcalSum + "kcal.");
        // TODO 5.1 j) Print a list of ingredients.
        for (int i = 0; i < index; i++) {
            System.out.println(amounts[i] + "g of " + ingredients[i]);
        }
    }

}
