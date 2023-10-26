import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MyData implements Comparable<MyData> {
    int day;
    int month;
    int year;
    String weekDay;

    public MyData() 
    {
        day = 0;
        month = 0;
        year = 0;
        weekDay = "None";
    }

    public MyData(int day, int month, int year, String weekDay) 
    {
        this.day = day;
        this.month = month;
        this.year = year;
        this.weekDay = weekDay;
    }

    public boolean equals(MyData myData)
    {
        return (
            day == myData.day && month == myData.month && 
            year == myData.year && weekDay.equals(myData.weekDay)
        );
    }

    public int compareTo(MyData otherData)
    {
        int diff = year - otherData.year;
        if (diff != 0) {
            return -diff;
        }
        diff = month - otherData.month;
        if (month != 0) {
            return -diff;
        }
        diff = day - otherData.day;
        return -diff;
    }

    public String toString() 
    {
        if (month < 10) {
            return (weekDay + " " + day + "." + "0" + month + "." + year);
        }
        return (weekDay + " " + day + "." + month + "." + year);
    }

    private int convertToInt(String str) 
    {
        int num = 0;
        try {
            num = Integer.parseInt(str);
            
        }
        catch (NumberFormatException ex) {
            System.out.println("Can't convert to integer!");
        }
        return num;
    }

    private void parseDate(String date, int formatIndex)
    {   
        if (formatIndex == 0) {
            String[] dandy = date.split(" ");
            String[] dateArr = dandy[0].split("/");
            day = convertToInt(dateArr[0]);
            month = convertToInt(dateArr[1]);
            year = convertToInt(dateArr[2]);
            weekDay = dandy[1];
        }
        else if (formatIndex == 1) {
            String[] dandy = date.split(" ");
            String[] dateArr = dandy[1].split("/");
            day = convertToInt(dateArr[0]);
            month = convertToInt(dateArr[1]);
            year = convertToInt(dateArr[2]);
            weekDay = dandy[0];
        }
        else if (formatIndex == 2) {
            String[] dandy = date.split(" ");
            String[] dateArr = dandy[0].split("-");
            year = convertToInt(dateArr[0]);
            month = convertToInt(dateArr[1]);
            day = convertToInt(dateArr[2]);
            weekDay = dandy[1];
        }
        else if (formatIndex == 3) {
            String[] dandy = date.split(" ");
            String[] dateArr = dandy[1].split(".");
            day = convertToInt(dateArr[0]);
            month = convertToInt(dateArr[1]);
            year = convertToInt(dateArr[2]);
            weekDay = dandy[0];
        }
    }

    public void setData(String data) 
    {
        String[] dateFormats = {
            "^\\d{2}/\\d{1,2}/\\d{4} [A-Za-z]+$",   // dd/mm/yyyy weekday
            "^[A-Za-z]+ \\d{2}/\\d{1,2}/\\d{4}$",   // weekday dd/mm/yyyy
            "^\\d{4}-\\d{2}-\\d{2} [A-Za-z]+$",     // yyyy-mm-dd weekday
            "^[A-Za-z]+ \\d{2}\\.\\d{2}\\.\\d{4}$", // weekday dd.mm.yyyy
        };

        int formatIndex = -1;
        for (int i = 0; i < dateFormats.length; ++i) {
            Pattern pattern = Pattern.compile(dateFormats[i], Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(data);

            if (matcher.find()) {
                formatIndex = i;
                break;
            }
        }

        parseDate(data, formatIndex);
    }
}
