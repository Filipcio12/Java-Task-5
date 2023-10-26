import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Collections;

class Main {

    private static String[] readFile(String filePath) 
    {
        String data = "";

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data += scanner.nextLine() + "\n";
            }
            data = data.substring(0, data.length() - 1);
            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
        
        return data.split("\n");
    }

    private static void createOutputFile()
    {
        File file = new File("MyData.txt");

        try {
            file.createNewFile();
        }
        catch (IOException ex) {
            System.out.println("Failed to create a file");
        }
    }

    private static void writeIntoFile(List<MyData> myDataObjs)
    {
        try {
            FileWriter writer = new FileWriter("MyData.txt");
            for (MyData myDataObj : myDataObjs) {
                writer.write(myDataObj + "\n");
            }
            writer.close();
        }
        catch (IOException ex) {
            System.out.println("Failed to write into a file");
        }
    }

    public static int convertDate(String filepath)
    {
        String[] data = readFile(filepath);
        createOutputFile();
        
        List<MyData> myDataObjs = new ArrayList<MyData>();

        for (String d : data) {
            MyData myData = new MyData();
            myData.setData(d);
            if (!myData.equals(new MyData())) {
                myDataObjs.add(myData);
            }
        }

        Collections.sort(myDataObjs);

        int numOfRewrites = 0;
        for (int i = 1; i < myDataObjs.size(); ++i) {
            if (myDataObjs.get(i).equals(myDataObjs.get(i - 1))) {
                myDataObjs.remove(i);
                numOfRewrites++;
            }
        }

        writeIntoFile(myDataObjs);

        return numOfRewrites;
    }
    public static void main(String[] args) {
        // IO
        // Date
        // Converting
        System.out.println(convertDate("InputData.txt"));
    }
}