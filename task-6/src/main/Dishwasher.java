package main;

public class Dishwasher {

	public static void main(String[] args) {
		Dish[] dishes = new Dish[10];
		dishes[0] = new Knife(0.5f);
		dishes[1] = new Spoon(0.5f);
		dishes[2] = new Fork(0.5f);
		dishes[3] = new Plate(0.6f);
		dishes[4] = new Plate(0.6f);
		dishes[5] = new Pot(0.8f);
		dishes[6] = new Plate(0.1f);
		dishes[7] = new Cup(0.9f);
		dishes[8] = new Pot(0.4f);
		dishes[9] = new Cutlery(0.4f);

		Dish[] dishesInDishwasher = new Dish[10];
		int filled = 0;
		int capacity = 20;
		for (int i = 0; i < dishes.length; i++) {
			if (capacity - filled >= dishes[i].size) {
				dishesInDishwasher[i] = dishes[i];
				filled += dishes[i].size;
			}
		}

		float dirtRemoved = 0.0f;
		float dirtRemaining = 0.0f;
		for (int i = 0; i < dishes.length; i++) {
			dishes[i].clean();
			dirtRemoved += dishes[i].dirtReduction;
			dirtRemaining += dishes[i].dirty;
		}
		System.out.println("Dirt removed: " + dirtRemoved);
		System.out.println("Dirt remaining: " + dirtRemaining);

		for (int i = 0; i < dishes.length; i++) {
			dishes[i].printStatus();
		}
	}
}
