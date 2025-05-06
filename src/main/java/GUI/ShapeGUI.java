// Ashley Cáceres Págan, UMGC, CMSC 335 7382, Project 2, 12 Nov. 2024.
// The ShapeGUI class serves as the main graphical user interface for the program. It allows users to select a shape
// from a dropdown menu, input the required dimensions (e.g., radius, side length), and calculate the area or volume
// of the selected shape. It interacts with the ShapePanel to render the selected shape dynamically and visually
// update the display. The class also manages user inputs and performs calculations using appropriate shape classes
// from the shapes package. It is the central entry point for user interactions and application execution.

package GUI;

import javax.swing.*;
import java.awt.*;
import shapes.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShapeGUI extends JFrame {

    private static final Logger logger = Logger.getLogger(ShapeGUI.class.getName());

    private final JComboBox<String> shapeDropdown;
    private final JTextField field1;
    private final JTextField field2;
    private final JLabel label1;
    private final JLabel label2;
    private final ShapePanel shapePanel;

    public ShapeGUI() {
        setTitle("Java OO Shapes Program");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Dropdown panel for shape selection
        JPanel panel = new JPanel();
        JLabel shapeLabel = new JLabel("Select a Shape:");
        String[] shapes = { "Circle", "Square", "Triangle", "Rectangle", "Sphere", "Cube", "Cone", "Cylinder", "Torus" };
        shapeDropdown = new JComboBox<>(shapes);
        panel.add(shapeLabel);
        panel.add(shapeDropdown);

        // Input panel for dimension inputs
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        label1 = new JLabel();
        field1 = new JTextField();
        field1.setPreferredSize(new Dimension(100, 25)); // Adjusted field size
        label2 = new JLabel();
        field2 = new JTextField();
        field2.setPreferredSize(new Dimension(100, 25)); // Adjusted field size

        inputPanel.add(label1);
        inputPanel.add(field1);
        inputPanel.add(label2);
        inputPanel.add(field2);

        label1.setVisible(false);
        field1.setVisible(false);
        label2.setVisible(false);
        field2.setVisible(false);

        // Shape display panel
        shapePanel = new ShapePanel();
        shapePanel.setPreferredSize(new Dimension(400, 300)); // Allocate enough space for rendering
        shapePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Optional: Add a border to visualize the panel's area

        // Calculate button
        JButton calculateButton = new JButton("Calculate");

        // Layout setup
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(shapePanel, BorderLayout.SOUTH);
        add(calculateButton, BorderLayout.PAGE_END);

        // Event listeners
        shapeDropdown.addActionListener(e -> {
            logger.log(Level.INFO, "Shape selected: " + shapeDropdown.getSelectedItem());
            updateInputFields();
        });
        calculateButton.addActionListener(e -> performCalculation());
    }

    private void updateInputFields() {
        String shape = (String) shapeDropdown.getSelectedItem();
        if (shape == null) {
            logger.log(Level.WARNING, "Shape selection is null. No updates to input fields.");
            label1.setVisible(false);
            field1.setVisible(false);
            label2.setVisible(false);
            field2.setVisible(false);
            return;
        }

        logger.log(Level.INFO, "Updating input fields for shape: " + shape);

        label1.setVisible(false);
        field1.setVisible(false);
        label2.setVisible(false);
        field2.setVisible(false);

        switch (shape) {
            case "Circle", "Sphere" -> {
                label1.setText("Radius:");
                label1.setVisible(true);
                field1.setVisible(true);
            }
            case "Square", "Cube" -> {
                label1.setText("Side:");
                label1.setVisible(true);
                field1.setVisible(true);
            }
            case "Triangle", "Rectangle", "Cone", "Cylinder", "Torus" -> {
                switch (shape) {
                    case "Triangle" -> {
                        label1.setText("Base:");
                        label2.setText("Height:");
                    }
                    case "Rectangle" -> {
                        label1.setText("Length:");
                        label2.setText("Width:");
                    }
                    case "Cone", "Cylinder" -> {
                        label1.setText("Radius:");
                        label2.setText("Height:");
                    }
                    case "Torus" -> {
                        label1.setText("Major Radius:");
                        label2.setText("Minor Radius:");
                    }
                }
                label1.setVisible(true);
                field1.setVisible(true);
                label2.setVisible(true);
                field2.setVisible(true);
            }
        }
    }

    private void performCalculation() {
        String shape = (String) shapeDropdown.getSelectedItem();
        if (shape == null) {
            logger.log(Level.SEVERE, "Calculation attempted without selecting a shape.");
            JOptionPane.showMessageDialog(this, "Please select a shape.");
            return;
        }

        logger.log(Level.INFO, "Performing calculation for shape: " + shape);

        double dim1;
        double dim2;
        String result;

        try {
            dim1 = Double.parseDouble(field1.getText());
            if (dim1 <= 0) throw new NumberFormatException();

            if (label2.isVisible()) {
                dim2 = Double.parseDouble(field2.getText());
                if (dim2 <= 0) throw new NumberFormatException();
            } else {
                dim2 = 0; // Default value if second dimension is not used
            }
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "Invalid numeric input for dimensions.");
            JOptionPane.showMessageDialog(this, "Please enter positive numeric values.");
            return;
        }

        switch (shape) {
            case "Circle":
                Circle circle = new Circle(dim1);
                result = "Area of Circle: " + circle.calculateArea();
                shapePanel.setShape("Circle", dim1, 0);
                break;
            case "Square":
                Square square = new Square(dim1);
                result = "Area of Square: " + square.calculateArea();
                shapePanel.setShape("Square", dim1, 0);
                break;
            case "Triangle":
                Triangle triangle = new Triangle(dim1, dim2);
                result = "Area of Triangle: " + triangle.calculateArea();
                shapePanel.setShape("Triangle", dim1, dim2);
                break;
            case "Rectangle":
                shapes.Rectangle rectangle = new shapes.Rectangle(dim1, dim2);
                result = "Area of Rectangle: " + rectangle.calculateArea();
                shapePanel.setShape("Rectangle", dim1, dim2);
                break;
            case "Sphere":
                Sphere sphere = new Sphere(dim1);
                result = "Volume of Sphere: " + sphere.calculateVolume();
                shapePanel.setShape("Sphere", dim1, 0);
                break;
            case "Cube":
                Cube cube = new Cube(dim1);
                result = "Volume of Cube: " + cube.calculateVolume();
                shapePanel.setShape("Cube", dim1, 0);
                break;
            case "Cone":
                Cone cone = new Cone(dim1, dim2);
                result = "Volume of Cone: " + cone.calculateVolume();
                shapePanel.setShape("Cone", dim1, dim2);
                break;
            case "Cylinder":
                Cylinder cylinder = new Cylinder(dim1, dim2);
                result = "Volume of Cylinder: " + cylinder.calculateVolume();
                shapePanel.setShape("Cylinder", dim1, dim2);
                break;
            case "Torus":
                Torus torus = new Torus(dim1, dim2);
                result = "Volume of Torus: " + torus.calculateVolume();
                shapePanel.setShape("Torus", dim1, dim2);
                break;
            default:
                logger.log(Level.SEVERE, "Invalid shape selected for calculation.");
                JOptionPane.showMessageDialog(this, "Invalid shape selected.");
                return;
        }

        result += "\n(Dimensions: " + (shape.equals("Circle") || shape.equals("Square") || shape.equals("Triangle") || shape.equals("Rectangle") ? 2 : 3) + ")";
        JOptionPane.showMessageDialog(this, result);
        shapePanel.repaint(); // Redraw the panel to update the display
        logger.log(Level.INFO, "Calculation complete for shape: " + shape);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            logger.log(Level.INFO, "Starting ShapeGUI...");
            ShapeGUI gui = new ShapeGUI();
            gui.setVisible(true);
        });
    }
}