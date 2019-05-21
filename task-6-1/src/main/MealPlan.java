package main;

public class MealPlan {

    public static void main(String[] args) {

	Meal meal = new Meal();

	Fruit[] fruits = new Fruit[5];
	fruits[0] = new Fruit("Banana", 96, true);
	fruits[1] = new Fruit("Apple", 52, false);
	fruits[2] = new Fruit("Orange", 47, true);
	fruits[3] = new Fruit("Cherry", 50, false);
	fruits[4] = new Fruit("Berries", 33, false);
	int[] weights = new int[5];
	weights[0] = 100; // 100g banana
	weights[1] = 120; // 120g apple
	weights[2] = 100; // 100g orange
	weights[3] = 60; // 60g cherry
	weights[4] = 40; // 40g berries

	for (int i = 0; i < fruits.length; i++) {
	    meal.addFruit(fruits[i], weights[i]);
	}

	/* TODO: 5.1 e) Remove the comment to generate some vegetable objects
	Vegetable[] vegetables = new Vegetable[5];
	vegetables[0] = new Vegetable("Pumpkin", 26, 15);
	vegetables[1] = new Vegetable("Broccoli", 34, 2);
	vegetables[2] = new Vegetable("Potato", 73, 10);
	vegetables[3] = new Vegetable("Beans", 295, 7);
	vegetables[4] = new Vegetable("Lintels", 335, 18);
	weights[0] = 150; // 150g pumpkin
	weights[1] = 30; // 30g broccoli
	weights[2] = 200; // 200g potato
	weights[3] = 100; // 100g beans
	weights[4] = 70; // 70g lintels

	for (int i = 0; i < vegetables.length; i++) {
	    // TODO 5.1 i) Cook the vegetable until it is edible
	    meal.addVegetable(vegetables[i], weights[i]);
	}
	*/

	meal.printStatus();
    }
}
