package shapes;

public abstract class TwoDimensionalShape extends Shape {
    public TwoDimensionalShape() {
        super(2);  // Setting dimensions for 2D shapes
    }

    public abstract double calculateArea();
}
