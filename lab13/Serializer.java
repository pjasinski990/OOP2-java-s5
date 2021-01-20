import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Serializer {
    private List<String> data = new ArrayList<>();
    public void serialize(String source, String target) {
        readData(source);
        try {
            ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(target));
            ostream.writeObject(data);
            ostream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void deserialize(String source, String target) {
        try {
            ObjectInputStream istream = new ObjectInputStream(new FileInputStream(source));
            data = (List<String>) istream.readObject();

            BufferedWriter writer = new BufferedWriter(new FileWriter(target));
            for (String s : data) {
                writer.write(s);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readData(String source) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(source));
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            Collections.sort(data, (o1, o2) -> o1.compareTo(o2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
