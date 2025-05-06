package shapes;

public class Cube extends ThreeDimensionalShape {
    private final double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double calculateVolume() {
        return Math.pow(side, 3);
    }

    @Override
    public String getDescription() {
        return "Cube with side length " + side;
    }
}
