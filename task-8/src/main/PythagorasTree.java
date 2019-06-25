package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PythagorasTree {

    public static void drawRotatedRect(Graphics2D g, Vector posP, Vector up, int a, int height) {
        // TODO 8.3.b) Draw a rectangle that is rotated according to the up vector

        // Zugegeben nicht die eleganteste Lösung, aber hey, funktioniert ziemlich gut (zeichne Rect, rotiere Rect, positioniere rect)
        Vector pos = new Vector(posP.x, posP.y);
        double angle = Math.atan2(up.y, up.x) - (2*Math.PI)/4;
        g.setColor(new Color(255 - a, 0, a));
        Vector upL, upR, doL, doR;
        upL = new Vector(0 - (double)(a/2), 0 - (double)(a/2));
        upR = new Vector(upL.x + a, upL.y);
        doL = new Vector(upL.x, upL.y + a);
        doR = new Vector(upL.x + a, upL.y + a);
        upL = upL.rotated(angle);
        upR = upR.rotated(angle);
        doL = doL.rotated(angle);
        doR = doR.rotated(angle);

        pos.y = height - pos.y;
        upL = upL.added(pos);
        upR = upR.added(pos);
        doL = doL.added(pos);
        doR = doR.added(pos);

        int[] x = {(int) upL.x, (int) upR.x,(int) doR.x,  (int) doL.x};
        int[] y = {(int) upL.y, (int) upR.y,(int) doR.y,  (int) doL.y};
        g.fillPolygon(x, y, 4);

    }

    public static void drawSegment(Graphics2D g, Vector pos, Vector up, int a, int height) {
        // TODO 8.3.c) Compute positions and orientations for the branches
        // continue recursively for every new branch
        //same here
        drawRotatedRect(g, pos, up, a, height);

        Vector newUpL = up.rotated(Math.PI/4);
        Vector newUpR = up.rotated(-Math.PI/4);

        double angle = Math.atan2(up.y, up.x) - (2*Math.PI)/4;
        Vector newPosL = pos.added(new Vector(-a/2, a).rotated(angle));
        Vector newPosR = pos.added(new Vector(a/2, a).rotated(angle));

        if (a >= 2){
            drawSegment(g, newPosL, newUpL, (int) (a/Math.sqrt(2)), height);
            drawSegment(g, newPosR, newUpR, (int) (a/Math.sqrt(2)), height);
        }
    }

    // Create the Pythagoras-Tree image and save it as PNG file.
    public static void createPythagorasTreeImage(int startSize) throws IOException {
        // Creation of the image object
        int height = 5 * startSize;
        int width = 8 * startSize;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Create a Graphics2D object from the image and set a white background
        Graphics2D g = image.createGraphics();
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, width, height);

        // Initial position and orientation of the first segment
        Vector startPos = new Vector(width / 2, startSize);
        Vector up = new Vector(0, 1);

        // Start the recursion.
        drawSegment(g, startPos, up, startSize, height);

        // Save the image as PNG
        String OS = System.getProperty("os.name").toLowerCase(); // different for win and unix
        String filePath = System.getProperty("user.dir") + (OS.indexOf("win") >= 0 ? "\\" : "/") + "pythagorasTree.png";
        System.out.println("Writing pythagoras-tree image to: " + filePath);
        ImageIO.write(image, "png", new File(filePath));
    }

    public static void main(String[] args) throws IOException {

        createPythagorasTreeImage(255);

    }
}
