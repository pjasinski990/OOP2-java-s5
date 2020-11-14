public class Point extends Shape {
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    String getCorner() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public String getName() {
        return "Point";
    }

    @Override
    public double area() {
        return 0.0;
    }

    @Override
    public double volume() {
        return 0.0;
    }

    @Override
    public String toString() {
        return getCorner();
    }

    double x;
    double y;
}
