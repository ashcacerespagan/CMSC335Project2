// Ashley Cáceres Págan, UMGC, CMSC 335 7382, Project 2, 12 Nov. 2024.
// The ShapePNGGenerator class is a utility class designed to generate PNG images for 3D shapes like spheres, cubes,
// and cones. These images are saved to the program's resource directory and are later used by the ShapePanel class
// for visual representation. It programmatically creates shapes using the Graphics2D class, allowing consistent,
// reusable images for the GUI. While not part of the core user interaction, this class supports the graphical rendering process.

package utilities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShapePNGGenerator {

    private static final Logger logger = Logger.getLogger(ShapePNGGenerator.class.getName());

    public static void main(String[] args) {
        createCircleImage();
        createSquareImage();
        createRectangleImage();
        createTriangleImage();
    }

    private static void createCircleImage() {
        int size = 200;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, size, size);

        g2d.setColor(Color.RED);
        g2d.fillOval(size / 4, size / 4, size / 2, size / 2);

        g2d.dispose();

        saveImage(image, "circle.png");
    }

    private static void createSquareImage() {
        int size = 200;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, size, size);

        g2d.setColor(Color.BLUE);
        g2d.fillRect(size / 4, size / 4, size / 2, size / 2);

        g2d.dispose();

        saveImage(image, "square.png");
    }

    private static void createRectangleImage() {
        int width = 300;
        int height = 150;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.GREEN);
        g2d.fillRect(width / 4, height / 4, width / 2, height / 2);

        g2d.dispose();

        saveImage(image, "rectangle.png");
    }

    private static void createTriangleImage() {
        int size = 200;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, size, size);

        g2d.setColor(Color.YELLOW);
        Polygon triangle = new Polygon();
        triangle.addPoint(size / 2, size / 4);
        triangle.addPoint(size / 4, 3 * size / 4);
        triangle.addPoint(3 * size / 4, 3 * size / 4);
        g2d.fillPolygon(triangle);

        g2d.dispose();

        saveImage(image, "triangle.png");
    }

    private static void saveImage(BufferedImage image, String fileName) {
        try {
            File outputFile = new File("src/main/resources/" + fileName); // Adjust path to resources
            ImageIO.write(image, "png", outputFile);
            System.out.println("Image saved to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to save image: " + fileName, e);
        }
    }
}