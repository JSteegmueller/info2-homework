package main;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Food objects are very simple and do not implement much functionality. The
 * foods value is determined randomly (with a maximum defined in the game) and
 * defines the color.
 */
public class Food extends LinkEntity {
    private int value;

    public Food(int x, int y) {
        super(new Vector(x, y), SnakeGame.foodBasic);
        value = 1 + ThreadLocalRandom.current().nextInt(SnakeGame.maxFoodValue);
        if (value < SnakeGame.maxFoodValue * 0.8) {
            col = SnakeGame.foodBasic;
        } else if (value == SnakeGame.maxFoodValue) {
            col = SnakeGame.foodSuper;
        } else {
            col = SnakeGame.foodUltra;
        }
    }

    public int getValue() {
        return value;
    }

}
