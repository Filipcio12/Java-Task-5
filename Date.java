public class Date implements Comparable<Date> {
    int day;
    int month;
    int year;
    String weekDay;

    public Date() {
        day = 0;
        month = 0;
        year = 0;
        weekDay = "None";
    }

    public Date(int day, int month, int year, String weekDay) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.weekDay = weekDay;
    }

    public boolean equals(Date oDate) {
        return (
            day == oDate.day && month == oDate.month && 
            year == oDate.year && weekDay.equals(oDate.weekDay)
        );
    }

    public int compareTo(Date oDate) {
        return(
            oDate.year - year + (oDate.month - month) / 12 + (oDate.day - day) / 365
        );
    }

    public String toString() {
        if (month < 10) {
            return (weekDay + " " + day + "." + "0" + month + "." + year);
        }
        return (weekDay + " " + day + "." + month + "." + year);
    }
}
