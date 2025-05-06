package shapes;

public class Cone extends ThreeDimensionalShape {
    private final double radius;
    private final double height;

    public Cone(double radius, double height) {
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Radius and height must be positive.");
        }
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " It is a Cone with radius " + radius + " and height " + height + ".";
    }
}
