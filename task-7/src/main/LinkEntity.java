package main;

import java.awt.*;

public abstract class LinkEntity {
    protected Vector pos;
    protected Color col;
    protected LinkEntity next;


    public LinkEntity(Vector pos, Color col) {
        this.pos = pos;
        this.col = col;
        next = this;
    }

    public int getLength() {
        if (!isLast()) {
            return 1 + getNext().getLength();
        }
        return 1;
    }

    public boolean isOccupied(int x, int y) {
        if (pos.x == x && pos.y == y) return true;
        else if (next != this) return next.isOccupied(x, y);
        return false;
    }

    public boolean isLast() {
        return next == this;
    }

    public Vector getPos() {
        return pos;
    }

    public Color getCol() {
        return col;
    }

    public void setCol(Color col) {
        this.col = col;
    }

    public void setPos(Vector pos) {
        this.pos = pos;
    }

    public LinkEntity setNext(LinkEntity next) {
        this.next = next;
        return next;
    }

    public LinkEntity getNext() {
        return next;
    }

    public void draw(Graphics2D g, Rectangle snakeArea, int tileSize) {
        g.setColor(col);
        g.fillRect(snakeArea.x + pos.x * tileSize, snakeArea.y + pos.y * tileSize, tileSize, tileSize);
        if (!isLast()) {
            (getNext()).draw(g, snakeArea, tileSize);
        }
    }

}
