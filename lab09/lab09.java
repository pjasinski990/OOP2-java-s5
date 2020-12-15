import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

final class Point {
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    private final int x, y;
    int getX() {return x;}
    int getY() {return y;}
}

final class Garden {
    public Garden(int sizeX, int sizeY, int n) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        data = new int[sizeX][sizeY];
        this.n = n;
    }

    public void digAreas(ArrayList<Point> startPoints, ArrayList<Point> endPoints) {
        for (int k = 0; k < n; ++k) {
            for (int i = startPoints.get(k).getX(); i < endPoints.get(k).getX(); ++i) {
                for (int j = startPoints.get(k).getY(); j < endPoints.get(k).getY(); ++j) {
                    data[i][j]++;
                }
            }
        }
    }

    public int getUnreadyCount() {
        int count = 0;
        for (int i = 0; i < sizeX; ++i) {
            for (int j = 0; j < sizeY; ++j) {
                if (data[i][j] >= n-1) {
                    count++;
                }
            }
        }
        return count;
    }

    private final int[][] data;
    private final int sizeX;
    private final int sizeY;
    private final int n;
}

public class lab09 {
    public static void main(String[] args) {
        ArrayList<Point> startPoints = new ArrayList<>();
        ArrayList<Point> endPoints = new ArrayList<>();
        final String filename = args[0];
        int n;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            n = Integer.parseInt(line);
            while ((line = reader.readLine()) != null) {
                String[] coords = line.split(" ", 4);
                int x1 = Integer.parseInt(coords[0]);
                int y1 = Integer.parseInt(coords[1]);
                int x2 = Integer.parseInt(coords[2]);
                int y2 = Integer.parseInt(coords[3]);
                startPoints.add(new Point(x1, y1));
                endPoints.add(new Point(x2, y2));
            }

            int maxX = endPoints.stream().max(Comparator.comparingInt(Point::getX)).get().getX();
            int maxY = endPoints.stream().max(Comparator.comparingInt(Point::getY)).get().getY();

            Garden g = new Garden(maxX, maxY, n);
            g.digAreas(startPoints, endPoints);
            System.out.println(g.getUnreadyCount());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
