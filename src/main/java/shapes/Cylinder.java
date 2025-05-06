package shapes;

public class Cylinder extends ThreeDimensionalShape {
    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Radius and height must be positive.");
        }
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " It is a Cylinder with radius " + radius + " and height " + height + ".";
    }
}
