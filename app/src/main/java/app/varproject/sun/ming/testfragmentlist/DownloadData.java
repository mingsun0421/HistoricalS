package app.varproject.sun.ming.testfragmentlist;

/**
 * Created by GOU on 12/06/2016.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class DownloadData {
    public static final int DATE = 0;
    public static final int OPEN = 1;
    public static final int HIGH = 2;
    public static final int LOW = 3;
    public static final int CLOSE = 4;
    public static final int VOLUME = 5;
    public static final int ADJCLOSE = 6;

    private ArrayList<MyDate> dates;
    private ArrayList<Double> opens;
    private ArrayList<Double> highs;
    private ArrayList<Double> lows;
    private ArrayList<Double> closes;
    private ArrayList<Integer> volumes;
    private ArrayList<Double> adjCloses;
    private Scanner input;

    public DownloadData(String symbol, MyDate start, MyDate end) {
        dates = new ArrayList<MyDate>();
        opens = new ArrayList<Double>();
        highs = new ArrayList<Double>();
        lows = new ArrayList<Double>();
        closes = new ArrayList<Double>();
        volumes = new ArrayList<Integer>();
        adjCloses = new ArrayList<Double>();

        //http://real-chart.finance.yahoo.com/table.csv?
        //s=BA&a=00&b=2&c=2014&d=05&e=6&f=2016&g=d&ignore=.csv
        String url = "http://real-chart.finance.yahoo.com/table.csv?s="
                +symbol+"&a=00&b=2&c=2014&d=05&e=6&f=2016&g=d&ignore=.csv";
        try {
            URL yhoofin = new URL(url);
            URLConnection data = yhoofin.openConnection();
            input = new Scanner(data.getInputStream());
            if(input.hasNext())//skip the header
                input.nextLine();

            while(input.hasNextLine()) {
                String line = input.nextLine();
                String[] subLine = line.split(",");
                String[] date = subLine[0].split("-");
                MyDate myDate = new MyDate(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
                dates.add(myDate);
                opens.add(Double.parseDouble(subLine[1]));
                highs.add(Double.parseDouble(subLine[2]));
                lows.add(Double.parseDouble(subLine[3]));
                closes.add(Double.parseDouble(subLine[4]));
                volumes.add(Integer.parseInt(subLine[5]));
                adjCloses.add(Double.parseDouble(subLine[6]));
                //System.out.println(line);
            }
        } catch(Exception e) {
            System.err.println(e);
        }
    }

    public ArrayList<MyDate> getDates() {
        return dates;
    }
    public ArrayList<Double> getOpens() {
        return opens;
    }
    public ArrayList<Double> getHighs() {
        return highs;
    }
    public ArrayList<Double> getLows() {
        return lows;
    }
    public ArrayList<Double> getCloses() {
        return closes;
    }
    public ArrayList<Integer> getVolumes() {
        return volumes;
    }
    public ArrayList<Double> getAdjCloses() {
        return adjCloses;
    }

}
