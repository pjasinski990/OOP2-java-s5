import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary = new HashMap<>();
    private String filename;

    public Dictionary(String filename) {
        try {
            this.filename = filename;
            File dictionaryFile = new File(filename);
            boolean isNew = false;
            if (!dictionaryFile.exists()) {
                isNew = dictionaryFile.createNewFile();
            }
            if (!isNew) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] tokens = line.split(" ");
                        dictionary.put(tokens[0], tokens[1]);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean containsWord(String word) {
        return dictionary.containsValue(word) || dictionary.containsKey(word);
    }

    void add(String key, String val) {
        if (containsWord(key)) {
            System.err.printf("Słowo %s już jest w słowniku...\n", key);
        }
        else if (containsWord(val)) {
            System.err.printf("Słowo %s już jest w słowniku...\n", val);
        }
        else {
            dictionary.put(key, val);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))){
                StringBuilder sb = new StringBuilder(key);
                sb.append(" ").append(val);
                writer.write(sb.toString());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    String getTranslation(String word) {
        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        }
        for (var entry : dictionary.entrySet()) {
            if (entry.getValue().equals(word)) {
                return entry.getKey();
            }
        }
        return "";
    }

    void remove(String word) {
        if (!containsWord(word)) {
            System.err.printf("Brak slowa %s w słowniku...\n", word);
            return;
        }
        dictionary.remove(word);
        for (var entry : dictionary.entrySet()) {
            if (entry.getValue().equals(word)) {
                dictionary.remove(entry.getKey());
            }
        }

        File temp = new File("temp");
        File dicFile = new File(filename);
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
                BufferedReader reader = new BufferedReader(new FileReader(dicFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(word)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            temp.renameTo(dicFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
