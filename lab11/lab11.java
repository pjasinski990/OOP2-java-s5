import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lab11 {
    public static void main(String[] args) {
        String filename = args[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            String[] values = line.split(" ");
            int elementsCount = Integer.parseInt(values[0]);
            int testsCount = Integer.parseInt(values[1]);

            Map<String, Set<String>> map = new HashMap<>(elementsCount);
            for (int i = 0; i < testsCount; ++i) {
                line = reader.readLine();
                values = line.split(" ");

                for (int j = 0; j < elementsCount / 2; ++j) {
                    String element = values[j];
                    if (!map.containsKey(element)) {
                        map.put(element, new HashSet<>());
                    }
                    for (int k = elementsCount / 2; k < elementsCount; ++k) {
                        map.get(element).add(values[k]);
                    }
                }
                for (int j = elementsCount / 2; j < elementsCount; ++j) {
                    String element = values[j];
                    if (!map.containsKey(element)) {
                        map.put(element, new HashSet<>());
                    }
                    for (int k = 0; k < elementsCount / 2; ++k) {
                        map.get(element).add(values[k]);
                    }
                }
            }

            boolean result = true;
            for (Set<String> set : map.values()) {
                if (set.size() < elementsCount - 1) {
                    result = false;
                    break;
                }
            }
            if (result) {
                System.out.println("TAK");
            } else {
                System.out.println("NIE");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
