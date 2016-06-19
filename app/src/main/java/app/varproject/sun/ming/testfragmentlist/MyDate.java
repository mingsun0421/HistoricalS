package app.varproject.sun.ming.testfragmentlist;

/**
 * Created by GOU on 12/06/2016.
 */

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear(){
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String toString() {
        return day+"/"+month+"/"+year;
    }
}
