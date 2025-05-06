package shapes;

public class Circle extends TwoDimensionalShape {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " It is a Circle with radius " + radius + ".";
    }
}
