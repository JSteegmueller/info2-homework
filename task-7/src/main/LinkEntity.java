package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class LinkEntity {
    protected Vector pos;
    protected Color col;
    protected LinkEntity next;
    protected String imagePath;


    public LinkEntity(Vector pos, Color col) {
        this.pos = pos;
        this.col = col;
        next = this;
        imagePath = null;
    }

    public int getLength() {
        if (!isLast()) {
            return 1 + getNext().getLength();
        }
        return 1;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
        if (imagePath != null){
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(img, null,snakeArea.x + pos.x * tileSize, snakeArea.y + pos.y * tileSize );
        } else {
            g.setColor(col);
            g.fillRect(snakeArea.x + pos.x * tileSize, snakeArea.y + pos.y * tileSize, tileSize, tileSize);
        }

        if (!isLast()) {
            (getNext()).draw(g, snakeArea, tileSize);
        }
    }

}
