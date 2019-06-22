package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mandelbrot {

    public static int mandelbrot(ComplexNumber c, ComplexNumber z, int n, int limit) {
        // TODO 8.2.b) check recursively if c is in the Mandelbrot-Set
        // Return an integer as described in the assignment PDF.
        if (n == limit) return 0;
        z = ComplexNumber.add(ComplexNumber.square(z), c);
        if (z.abs() > 2) return n;
        else {
            n++;
            return mandelbrot(c,z,n,limit);
        }
    }

    // Create the Mandelbrot image, fill it and save it as PNG file.
    public static void createMandelbrotImage(int tileSize, int maxRecurse) throws IOException {
        int height = 2 * tileSize;
        int width = 3 * tileSize;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        ComplexNumber z0 = new ComplexNumber(0, 0);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Construct a complex number from the pixel coordinates
                float xPos = (x + 0.5f - 2 * tileSize) / tileSize;
                float yPos = (y + 0.5f - tileSize) / tileSize;
                ComplexNumber c = new ComplexNumber(xPos, yPos);

                // Check the Mandelbrot condition for this complex number
                int mb = mandelbrot(c, z0, 0, maxRecurse);

                // Translate the result to number in a reasonable range and use it as color.
                double mbl = mb > 0 ? Math.log(mb) / Math.log(maxRecurse) : 0;
                image.setRGB(x, y, (int) (mbl * 255));
            }
        }

        // Save the image as PNG
        String OS = System.getProperty("os.name").toLowerCase(); // different for win and unix
        String filePath = System.getProperty("user.dir") + (OS.indexOf("win") >= 0 ? "\\" : "/") + "mandelbrot.png";
        System.out.println("Writing mandelbrot image to: " + filePath);
        ImageIO.write(image, "png", new File(filePath));
    }

    public static void main(String[] args) throws IOException {

        createMandelbrotImage(500, 2 ^ 24);

    }
}
