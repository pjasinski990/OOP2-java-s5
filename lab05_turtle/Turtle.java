/**
 * Class that implements execution of basic turtle commands.
 * Possible commands are enumerated in {@link CommandType} enum.
 *
 * Turtle works by printing coordinates of points that create lines to the file.
 * Resulting file can then be then used with gnuplot to render a picture.
 */
public class Turtle {
    private double x = 0.0;
    private double y = 0.0;
    private double angle = Math.PI / 2.0; // rads

    /**
     * Draws line from current position for length of distance.
     * @param distance length of line drawn
     */
    public void draw(double distance) {
        System.out.printf("%f %f\n", x, y);
        x += distance * Math.cos(angle);
        y += distance * Math.sin(angle);
        System.out.printf("%f %f\n", x, y);
    }

    /**
     * Moves turtle from current position for length of distance without drawing.
     * @param distance distance to be covered
     */
    public void move(double distance) {
        System.out.printf("\n");
        x += distance * Math.cos(angle);
        y += distance * Math.sin(angle);
    }

    /**
     * Rotates turtle right.
     * @param degrees amount of degrees to be rotated for
     */
    public void right(double degrees) {
        angle += degrees / 180.0 * Math.PI;
    }

    /**
     * Rotates turtle left.
     * @param degrees amount of degrees to be rotated for
     */
    public void left(double degrees) {
        angle -= degrees / 180.0 * Math.PI;
    }

    /**
     * Returns turtle to default position.
     */
    public void home() {
        System.out.printf("\n");
        x = 0.0;
        y = 0.0;
        angle = Math.PI / 2.0;
    }

    /**
     * Executes passed command on this turtle. Possible commands are enumerated in {@link CommandType}.
     * @param c command to be executed
     */
    public void execute (Command c) {
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
