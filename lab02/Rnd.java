import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Rnd {
    private ArrayList<Double> list;
    private Random r = new Random();

    public Rnd(int arraySize, int rollCount) {
        list = new ArrayList<Double>(arraySize);
        for(int i = 0; i < arraySize; i++) {
            double sum = 0.0;
            for (int j = 0; j < rollCount; j++) {
                sum += r.nextDouble();
            }
            list.add(sum);
        }
    }

    public void Print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("[%d]=%f\n", i, list.get(i));
        }
    }

    public double Max() {
        return Collections.max(list);
    }

    public double Min() {
        return Collections.min(list);
    }

    public double Average() {
        double sum = 0.0;
        for (double d: list) {
            sum += d;
        }
        return sum/list.size();
    }

    public void Draw() {
        double min = Min();
        double range = Max() - min;
        for (int i = 0; i < list.size(); i++) {
            int ratio = (int)((list.get(i) - min) * 50 / range);
            System.out.printf("[%d]:%s\n", i, "*".repeat(ratio));
        }
    }
}
