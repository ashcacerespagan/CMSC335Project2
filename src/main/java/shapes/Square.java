package shapes;

public class Square extends TwoDimensionalShape {
    private final double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side length must be positive.");
        }
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " It is a Square with side length " + side + ".";
    }
}
