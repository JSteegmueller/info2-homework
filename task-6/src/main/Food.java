package main;

public abstract class Food {

	//Weshalb hat die Klasse kein weight? Die Abstraktion macht keinen Sinn...
	public String name;
	public int kcal; // per 100g
	protected boolean edible;

	//int wenn wir das ganze mit 0.9 multiplizieren? Nice
	public abstract int prepare(int weight);

	public Food(String _name, int _kcal) {
		name = _name;
		kcal = _kcal;
		edible = false;
	}

	public float computeCalories(float gramms) {
		// Die Schale ist egal oder wie?? Also das unterscheidet sich schon zwischen Fruit und Vegetable....
		// TODO complete the computation
		return (edible) ? (kcal / 100.0f) * gramms : 0;
	}

}
