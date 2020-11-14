import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class lab05 {
    public static void main(String args[]) {
        final String inputFile = "turtle.txt";

        CommandQ queue = new CommandQ();
        CommandParser parser = new CommandParser();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = reader.readLine()) != null) {
                Command nextCommand = parser.parseCommand(line);
                if (nextCommand != null) {
                    queue.enQ(nextCommand);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.printf("%s %s\n", "Error opening file ", inputFile);
            System.exit(-1);
        } catch (IOException e) {
            System.err.printf("%s %s\n", "Error reading file ", inputFile);
            System.exit(-1);
        }

        Turtle leonardo = new Turtle();
        Command command;
        while((command = queue.deQ()) != null) {
            leonardo.execute(command);
        }
    }
}
