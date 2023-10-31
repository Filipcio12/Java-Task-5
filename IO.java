import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class IO {
    String[] data;

    public void readFile(String filePath) {
        String text = "";
        File file = new File(filePath);
        try {
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
    }

    public void writeFile(String filePath, List<MyData> myDatas) {
        File file = new File(filePath);
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(filePath);
            for (MyData myData : myDatas) {
                writer.write(myData + "\n");
            }
            writer.close();
        }
        catch (IOException ex) {
            System.out.println("Failed to create a file");
        }
    }
}
