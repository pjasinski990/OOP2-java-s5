public class Turtle {
    private double x = 0.0;
    private double y = 0.0;
    private double angle = Math.PI / 2.0; // rads

    public void draw(double distance) {
        System.out.printf("%f %f\n", x, y);
        x += distance * Math.cos(angle);
        y += distance * Math.sin(angle);
        System.out.printf("%f %f\n", x, y);
    }

    public void move(double distance) {
        System.out.printf("\n");
        x += distance * Math.cos(angle);
        y += distance * Math.sin(angle);
    }

    public void right(double degrees) {
        angle += degrees / 180.0 * Math.PI;
    }

    public void left(double degrees) {
        angle -= degrees / 180.0 * Math.PI;
    }

    public void home() {
        System.out.printf("\n");
        x = 0.0;
        y = 0.0;
        angle = Math.PI / 2.0;
    }

    void execute (Command c) {
        switch(c.type) {
            case DRAW:
                draw(c.x);
                break;
            case MOVE:
                move(c.x);
                break;
            case RIGHT:
                right(c.x);
                break;
            case LEFT:
                left(c.x);
                break;
            case HOME:
                home();
            default:
                break;
        }
    }
}
