import java.io.*;

public class lab08 {
    public static void main(String[] args) {
        try {
            final String inputFilename = args[0];
            final String outputFilename = args[1];

            BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
            FileWriter writer = new FileWriter(outputFilename);

            try {
                String line = reader.readLine();
                int sum = 0;
                int count = 0;
                while (line != null) {
                    sum += Integer.parseInt(line);
                    count++;
                    line = reader.readLine();
                }

                if (count == 0) {
                    throw new ArithmeticException();
                }

                double avg = (double)sum / (double)count;
                writer.write(Double.toString(avg));
                writer.write("\n");

            } catch (NumberFormatException e) {
                System.err.println("Error converting line to a number (line is not an integer)\n");

            } catch (ArithmeticException e) {
                System.err.println("Error: division by zero (data file empty)");
            }

            reader.close();
            writer.close();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Not enough parameters specified. Usage: $java lab08 inputFilename outputFilename");

        } catch (FileNotFoundException e) {
            System.err.println("Specified data file not found.");

        } catch (IOException e) {
            System.err.println("Unexpected IO Error");
        }
    }
}
