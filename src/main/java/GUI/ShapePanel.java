// Ashley Cáceres Págan, UMGC, CMSC 335 7382, Project 2, 12 Nov. 2024.
// The ShapePanel class is responsible for rendering shapes in the GUI. It dynamically draws 2D shapes
// (like circles and rectangles) or displays preloaded images representing 3D shapes (like spheres and cubes).
// panel listens for updates from the ShapeGUI class when a shape is selected and repaints itself accordingly. This
// class also includes functionality to log rendering actions and handles the background visuals of the shape rendering area.

package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ShapePanel extends JPanel {
    private static final Logger logger = Logger.getLogger(ShapePanel.class.getName());
    private final Map<String, BufferedImage> shapeImages = new HashMap<>();
    private String shapeType;
    private double dim1;
    private double dim2;

    public ShapePanel() {
        setBackground(Color.LIGHT_GRAY); // Set a background color for debugging visibility
        setPreferredSize(new Dimension(400, 300)); // Set a fixed size for testing
        loadShapeImages();
    }

    private void loadShapeImages() {
        try {
            String[] shapes = {"sphere", "cube", "cone", "cylinder", "torus"};
            for (String shape : shapes) {
                var resourcePath = getClass().getResource("/" + shape + ".png");
                if (resourcePath != null) {
                    logger.log(Level.INFO, "Successfully loaded image for: " + shape);
                    shapeImages.put(shape.substring(0, 1).toUpperCase() + shape.substring(1), ImageIO.read(resourcePath));
                } else {
                    logger.log(Level.WARNING, "Resource not found for: " + shape);
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load one or more images", e);
        }
    }

    public void setShape(String shapeType, double dim1, double dim2) {
        this.shapeType = shapeType;
        this.dim1 = dim1;
        this.dim2 = dim2;
        logger.log(Level.INFO, "setShape called with: " + shapeType);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        logger.log(Level.INFO, "ShapePanel dimensions: " + getWidth() + "x" + getHeight());

        // Hardcoded test drawing
        g2d.setColor(Color.RED);
        g2d.fillOval(50, 50, 100, 100); // Draw a test circle
        logger.log(Level.INFO, "Test circle drawn.");

        if (shapeType == null) {
            logger.log(Level.INFO, "No shape type set; nothing to draw.");
            return;
        }

        logger.log(Level.INFO, "Drawing shape: " + shapeType);

        int x = 50;
        int y = 50;

        switch (shapeType) {
            case "Circle" -> {
                logger.log(Level.INFO, "Rendering Circle with radius: " + dim1);
                int radius = (int) dim1;
                g2d.setColor(Color.BLUE);
                g2d.fillOval(x, y, radius * 2, radius * 2);
            }
            case "Sphere" -> {
                BufferedImage image = shapeImages.get("Sphere");
                if (image != null) {
                    logger.log(Level.INFO, "Rendering image for: Sphere");
                    g2d.drawImage(image, x, y, null);
                } else {
                    logger.log(Level.WARNING, "Image for Sphere is null or missing!");
                    g2d.drawString("Image not available for Sphere", x, y);
                }
            }
            default -> logger.log(Level.WARNING, "Unknown shape type: " + shapeType);
        }
    }
}
