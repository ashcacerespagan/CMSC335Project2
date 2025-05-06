package shapes;

public class Sphere extends ThreeDimensionalShape {
    private final double radius;

    public Sphere(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " It is a Sphere with radius " + radius + ".";
    }
}
