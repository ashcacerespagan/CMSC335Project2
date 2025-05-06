package shapes;

public abstract class ThreeDimensionalShape extends Shape {
    public ThreeDimensionalShape() {
        super(3);  // Setting dimensions for 3D shapes
    }

    public abstract double calculateVolume();
}
