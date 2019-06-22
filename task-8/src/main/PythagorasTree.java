package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PythagorasTree {

    // TODO 8.3.a) This is just a dummy-class, for the exercise to compile.
    // After you implemented your own Vector class, you can remove this:
    static class Vector {
	public Vector(double a, double b) {
	}
    };

    public static void drawRotatedRect(Graphics2D g, Vector pos, Vector up, int a, int height) {
	// TODO 8.3.b) Draw a rectangle that is rotated according to the up vector
    }

    public static void drawSegment(Graphics2D g, Vector pos, Vector up, int a, int height) {
	// TODO 8.3.c) Compute positions and orientations for the branches
	// continue recursively for every new branch
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

	createPythagorasTreeImage(256);

    }
}
