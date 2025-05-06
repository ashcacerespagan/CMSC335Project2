package shapes;

public abstract class Shape {
    private final int numberOfDimensions;

    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    public String getDescription() {
        return "This is a " + numberOfDimensions + "-dimensional shape.";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
