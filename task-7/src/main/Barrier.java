package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * The barrier surrounds the game area and spawns new elements of increasing
 * number (based on the level) within the game area. The first constructor sets
 * the base block at (-1,-1) and initializes the rest of the field with the
 * other private constructor.
 */
public class Barrier {

    private Rectangle borderArea;
    protected Vector pos;
    protected Color col;
    private Barrier next;

    public Barrier(Rectangle _gameArea, int level) {
        pos = new Vector(-1, -1);
        col = SnakeGame.arenaBarrier;
        next = setNext(this);

        borderArea = new Rectangle(_gameArea.x / MainFrame.tileSize, _gameArea.y / MainFrame.tileSize,
                _gameArea.width / MainFrame.tileSize, _gameArea.height / MainFrame.tileSize);

        for (int y = 0; y < borderArea.height; y++) {
            for (int x = 0; x < borderArea.width; x++) {
                if (y == 0 || x == 0 || y == (borderArea.height - 1) || x == (borderArea.width - 1)) {
                    extend(x - 1, y - 1);
                }
            }
        }

        // TODO: spawn barriers randomly on unoccupied terrain

    }

    private Barrier(int _x, int _y) {
        pos = new Vector(_x, _y);
        col = SnakeGame.arenaBarrier;
        setNext(this);
    }

    public boolean isOccupied(int x, int y) {
        if (pos.x == x && pos.y == y) return true;
        else if (next != this) return next.isOccupied(x, y);
        return false;
    }

    public boolean isLast() {
        return next == this;
    }

    public Barrier setNext(Barrier _next) {
        next = _next;
        return next;
    }

    public Barrier getNext() {
        return next;
    }

    public void extend(int _x, int _y) {
        if (isLast()) {
            next = (Barrier) setNext(new Barrier(_x, _y));
        } else {
            next = (Barrier) getNext();
            next.extend(_x, _y);
        }
    }

    public void draw(Graphics2D g, Rectangle snakeArea, int tileSize) {
        g.setColor(col);
        g.fillRect(snakeArea.x + pos.x * tileSize, snakeArea.y + pos.y * tileSize, tileSize, tileSize);
        if (!isLast()) {
            next.draw(g, snakeArea, tileSize);
        }
    }

}
