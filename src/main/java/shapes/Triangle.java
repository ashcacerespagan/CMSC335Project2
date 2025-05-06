package shapes;

public class Triangle extends TwoDimensionalShape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be positive.");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " It is a Triangle with base " + base + " and height " + height + ".";
    }
}
