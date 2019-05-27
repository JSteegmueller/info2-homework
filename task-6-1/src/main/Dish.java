package main;

/**
 * Ja also das hier ist halt die Klasse wie sie in der Aufgabe beschrieben ist,
 * Dish hat:
 * - Name name
 * - Schmutzgrad dirty
 * - größe Size mit get-Methode
 * - Top Konstruktor Dish
 * - Sexy Methoden wie printStatus die den Status des Dishes printed (deshalb void) und
 * - clean welches den ganzen Schmutz von dem dish entfernt (auch void) mit nem Parameter wie arg die Spühlmaschiene halt so abgeht.
 **/

public class Dish {
    private String name;
    private float dirty;
    private int size;

    public Dish(String name, float dirty) {
        this.name = name;
        determineSize(name);

        if (dirty >= 0 && dirty <= 1) {
            this.dirty = dirty;
        } else {
            this.dirty = 1f;
        }
    }

    public void determineSize(String name) {
        if (name.equals("Cutlery")) {
            size = 1;
        } else if (name.equals("Plate")) {
            size = 2;
        } else if (name.equals("Cup")) {
            size = 2;
        } else if (name.equals("Pot")) {
            size = 5;
        } else {
            //Wir gehen mal vom schlimmsten aus, nicht dass unsere gute teure Spühlmaschiene noch überlastet wird ;P
            size = Integer.MAX_VALUE;
        }
    }

    public void clean(float amountOfClean) {
        dirty -= amountOfClean;
        if (dirty < 0) dirty = 0;
    }

    public void printStatus() {
        System.out.println("Name: " + name);
        System.out.println(dirty);
        System.out.println((dirty <= 0.1) ? "is clean" : "still dirty");
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}
