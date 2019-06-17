package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The barrier surrounds the game area and spawns new elements of increasing
 * number (based on the level) within the game area. The first constructor sets
 * the base block at (-1,-1) and initializes the rest of the field with the
 * other private constructor.
 */
public class Barrier extends LinkEntity {

    private Rectangle borderArea;
    private Barrier next;

    public Barrier(Rectangle _gameArea, int level) {
        super(new Vector(-1, -1), SnakeGame.arenaBarrier);

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
        int x, y;
        for (int i = 0; i <= level; i++) {
            do {
                x = ThreadLocalRandom.current().nextInt(borderArea.width - 1);
                y = ThreadLocalRandom.current().nextInt(borderArea.height - 1);
            } while (this.isOccupied(x, y) || SnakeGame.initialSnakeDir.equals(new Vector(x, y)));
            extend(x, y);
        }
    }

    private Barrier(int _x, int _y) {
        super(new Vector(_x, _y), SnakeGame.arenaBarrier);
    }

    public void extend(int _x, int _y) {
        if (isLast()) {
            next = (Barrier) setNext(new Barrier(_x, _y));
        } else {
            next = (Barrier) getNext();
            next.extend(_x, _y);
        }
    }
}
