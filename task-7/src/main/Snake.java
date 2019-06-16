package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * The snake has two constructors, the first one (public) is for the head only,
 * the other one for the rest of the body (private). As the snake moves, it can
 * eat and extend its length, run into itself and lose length or run into a
 * barrier and die.
 */
public class Snake {

    protected Vector pos;
    protected Color col;
    private boolean alive;
    private int lives;
    private int wait;
    private Vector dir;
    private Snake next;

    public Snake(int _x, int _y, int _lives, int _startLength) {
        pos = new Vector(_x, _y);
        setNext(this);

        alive = true;
        lives = _lives;
        wait = 0;

        dir = SnakeGame.initialSnakeDir;
        col = SnakeGame.snakeHead;

        extend(_startLength - 1);
    }

    private Snake(Vector _pos, Vector _dir, int n) {
        pos = new Vector(_pos.x, _pos.y);
        setNext(this);

        alive = true;
        wait = n;

        dir = _dir;
        col = SnakeGame.snakeBody;
    }

    public void changeDirection(Vector newDir) {
        Vector tmp = dir;
        dir = newDir;
        if(!isLast()) next.changeDirection(tmp);
    }

    public Snake setNext(Snake _next) {
        next = _next;
        return next;
    }

    public Snake getNext() {
        return next;
    }

    public int getLength() {
        if (!isLast()) {
            return 1 + next.getLength();
        }
        return 1;
    }

    public boolean isOccupied(int x, int y) {
        if (pos.x == x && pos.y == y) return true;
        else if (next != this) return next.isOccupied(x, y);
        return false;
    }

    public boolean isAlive() {
        alive = lives > 0;
        return alive;
    }

    public int getLives() {
        return lives;
    }

    public boolean isLast() {
        return next == this;
    }

    private void extend(int n) {
        for (int i = n; i > 0; i--) {
            Snake cur = this;
            while (!cur.isLast()) {
                cur = cur.next;
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
        if(!isLast()) next.move();
    }

    private boolean selfCollision(Vector headPos) {
        Snake curr = this.next;
        while (!curr.isLast()){
            if (headPos.equals(curr.pos)){
                curr.next = curr;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void draw(Graphics2D g, Rectangle snakeArea, int tileSize) {
        g.setColor(col);
        g.fillRect(snakeArea.x + pos.x * tileSize, snakeArea.y + pos.y * tileSize, tileSize, tileSize);
        if (!isLast()) {
            next.draw(g, snakeArea, tileSize);
        }
    }
}
