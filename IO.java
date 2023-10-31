import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class IO {
    public static String[] readFile(String filePath) {
        String[] data = new String[0];
        String text = "";
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                text += scanner.nextLine() + "\n";
            }
            text = text.substring(0, text.length() - 1);
            scanner.close();
            data = text.split("\n");
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        return data;
    }

    public static void writeFile(String filePath, List<Date> dates) {
        File file = new File(filePath);
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(filePath);
            for (Date date : dates) {
                writer.write(date + "\n");
            }
            writer.close();
        }
        catch (IOException ex) {
            System.out.println("Failed to create a file");
        }
    }
}
