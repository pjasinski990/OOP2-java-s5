public class Square extends Point {
    public Square(double side, double x, double y) {
        super(x, y);
        this.side = side;
    }

    String getCornerAndSide() {
        return "Corner = " + super.getCorner() + "; side = " + side;
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double volume() {
        return 0.0;
    }

    @Override
    public String toString() {
        return getCornerAndSide();
    }

    double side;
}
