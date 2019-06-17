package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * The snake has two constructors, the first one (public) is for the head only,
 * the other one for the rest of the body (private). As the snake moves, it can
 * eat and extend its length, run into itself and lose length or run into a
 * barrier and die.
 */
public class Snake extends LinkEntity {

    private boolean alive;
    private int lives;
    private int wait;
    private Vector dir;

    public Snake(int _x, int _y, int _lives, int _startLength) {
        super(new Vector(_x, _y), SnakeGame.snakeHead);

        alive = true;
        lives = _lives;
        wait = 0;

        dir = SnakeGame.initialSnakeDir;

        extend(_startLength - 1);
    }

    private Snake(Vector _pos, Vector _dir, int n) {
        super(_pos, SnakeGame.snakeBody);
        pos = new Vector(_pos.x, _pos.y);

        alive = true;
        wait = n;

        dir = _dir;
    }

    public void changeDirection(Vector newDir) {
        Vector tmp = dir;
        dir = newDir;
        if(!isLast()) ((Snake) getNext()).changeDirection(tmp);
    }

    public boolean isAlive() {
        alive = lives > 0;
        return alive;
    }

    public int getLives() {
        return lives;
    }

    private void extend(int n) {
        for (int i = n; i > 0; i--) {
            Snake cur = this;
            while (!cur.isLast()) {
                cur = ((Snake) cur.getNext());
            }
            cur.next = new Snake(pos, dir, getLength());
            cur.next.next = cur.next;
        }
    }

    private boolean eat(Food food) {
        if (pos.equals(food.getPos())) {
            if (food.getValue() == SnakeGame.maxFoodValue) lives++;
            else extend(food.getValue());
            return true;
        }
        return false;
    }

    public boolean move(Food food, Barrier barrier) {
        move();
        if (selfCollision(pos)) lives--;
        else if (barrier.isOccupied(pos.x, pos.y)) lives = 0;
        else return eat(food);

        return false;
    }

    private void move() {
        if (wait > 0) {
            wait -= 1;
        } else {
            pos.x += dir.x;
            pos.y += dir.y;
        }
        if(!isLast()) ((Snake) getNext()).move();
    }

    private boolean selfCollision(Vector headPos) {
        Snake curr = ((Snake) getNext());
        while (!curr.isLast()){
            if (headPos.equals(curr.pos)){
                curr.next = curr;
                return true;
            }
            curr = ((Snake) curr.getNext());
        }
        return false;
    }

}
