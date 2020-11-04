public class lab01 {
    private static final int STEPS_LINE = 20;
    private static final double STEP_ANGLE = 0.05;

    private static void draw_line(double x1, double y1, double x2, double y2) {
        double diffx = (x2 - x1) / STEPS_LINE;
        double diffy = (y2 - y1) / STEPS_LINE;
        for (int i = 0; i <= STEPS_LINE; i++) {
            System.out.printf("%f %f\r\n", x1 + diffx*i, y1 + diffy*i);
        }
    }

    private static void draw_circle(int x, int y, int r) {
        for (double d = 0.0; d <= 2*Math.PI; d += STEP_ANGLE) {
            System.out.printf("%f %f\r\n", x + r * Math.cos(d), y + r * Math.sin(d));
        }
    }

    public static void main(String[] args) {
        draw_line(28,65,28,84);
        draw_line(28,84,34,83);
        draw_line(34,83,38,79);
        draw_line(38,79,37,76);
        draw_line(37,76,34,73);
        draw_line(28,72,37,76);
        draw_line(58,25,53,23);
        draw_line(53,23,47,23);
        draw_line(47,23,44,25);
        draw_line(74,65,63,65);
        draw_line(63,65,73,74);
        draw_line(73,74,73,79);
        draw_line(73,79,70,82);
        draw_line(70,82,66,82);
        draw_line(66,82,63,80);
        draw_circle(50,74,9);
        draw_circle(50,29,14);
        draw_circle(55,34,2);
        draw_circle(46,34,2);
    }
}