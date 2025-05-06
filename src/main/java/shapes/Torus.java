package shapes;

public class Torus extends ThreeDimensionalShape {
    private final double majorRadius;
    private final double minorRadius;

    public Torus(double majorRadius, double minorRadius) {
        if (majorRadius <= 0 || minorRadius <= 0) {
            throw new IllegalArgumentException("Major and minor radii must be positive.");
        }
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    @Override
    public double calculateVolume() {
        return 2 * Math.PI * Math.PI * majorRadius * Math.pow(minorRadius, 2);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " It is a Torus with major radius " + majorRadius + " and minor radius " + minorRadius + ".";
    }
}
