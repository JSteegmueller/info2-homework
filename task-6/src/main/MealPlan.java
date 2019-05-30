package main;

public class MealPlan {

	public static void main(String[] args) {

		Meal meal = new Meal();

		// TODO after implementing the Vegetable class:
		// change the foods array to a size of 10
		// and uncomment the Vegetable block below
		Food[] foods = new Food[10];
		foods[0] = new Fruit("Banana", 96, true);
		foods[1] = new Fruit("Apple", 52, false);
		foods[2] = new Fruit("Orange", 47, true);
		foods[3] = new Fruit("Cherry", 50, false);
		foods[4] = new Fruit("Berries", 33, false);

		foods[5] = new Vegetable("Pumpkin", 26, 15);
		foods[6] = new Vegetable("Broccoli", 34, 2);
		foods[7] = new Vegetable("Potato", 73, 10);
		foods[8] = new Vegetable("Beans", 295, 7);
		foods[9] = new Vegetable("Lintels", 335, 18);


		int[] weights = new int[10];
		weights[0] = 100; // 100g banana
		weights[1] = 120; // 120g apple
		weights[2] = 100; // 100g orange
		weights[3] = 60; // 60g cherry
		weights[4] = 40; // 40g berries
		weights[5] = 150; // 150g pumpkin
		weights[6] = 30; // 30g broccoli
		weights[7] = 200; // 200g potato
		weights[8] = 100; // 100g beans
		weights[9] = 70; // 70g lintels

		for (int i = 0; i < foods.length; i++) {
			int weight = foods[i].prepare(weights[i]);

			// TODO activate this after you implemented it
			meal.addFood(foods[i], weight);
		}

		meal.printStatus();
	}
}
