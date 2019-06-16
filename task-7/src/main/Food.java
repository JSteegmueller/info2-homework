package main;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Food objects are very simple and do not implement much functionality. The
 * foods value is determined randomly (with a maximum defined in the game) and
 * defines the color.
 */
public class Food {
    private Vector pos;
    private int value;
    private Color col;

    public Food(int x, int y) {
        pos = new Vector(x, y);
        value = 1 + ThreadLocalRandom.current().nextInt(SnakeGame.maxFoodValue);
        if (value < SnakeGame.maxFoodValue * 0.8) {
            col = SnakeGame.foodBasic;
        } else if (value == SnakeGame.maxFoodValue) {
            col = SnakeGame.foodSuper;
        } else {
            col = SnakeGame.foodUltra;
        }
    }

    public Vector getPos() {
        return pos;
    }

    public int getValue() {
        return value;
    }

    public void draw(Graphics2D g, Rectangle snakeArea, int tileSize) {
        g.setColor(col);
        g.fillRect(snakeArea.x + pos.x * tileSize, snakeArea.y + pos.y * tileSize, tileSize, tileSize);
    }
}
