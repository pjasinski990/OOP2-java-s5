public class Cube extends Square {
    public Cube(double side, double x, double y) {
        super(side, x, y);
    }

    String getCornerSideAndDepth() {
        return super.getCornerAndSide() + "; depth = " + side;
    }

    @Override
    public String getName() {
        return "Cube";
    }

    @Override
    public double area() {
        return super.area() * 6.0;
    }

    @Override
    public double volume() {
        return side * side * side;
    }

    @Override
    public String toString() {
        return getCornerSideAndDepth();
    }
}
