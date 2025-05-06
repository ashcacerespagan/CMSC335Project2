package shapes;

public class Rectangle extends TwoDimensionalShape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive.");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " It is a Rectangle with length " + length + " and width " + width + ".";
    }
}
