import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Collections;

class Main {
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
    }
}