package app.varproject.sun.ming.testfragmentlist;

/**
 * Created by GOU on 12/06/2016.
 */

import android.os.AsyncTask;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class StockDataList extends AsyncTask<String, Integer, ArrayList<StockData>> {
    private ArrayList<StockData> dataList;
    private String symbol;
    private Scanner input;

    public StockDataList(String symbol) {
        dataList = new ArrayList<StockData>();
        this.symbol = symbol;
    }

    public void DownloadList() {
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
                String open = subLine[1];
                String high = subLine[2];
                String low = subLine[3];
                String close = subLine[4];
                String volume = subLine[5];
                String adjClose = subLine[6];

                StockData stockData = new StockData(myDate,open,high,low,close,volume,adjClose);
                dataList.add(stockData);
            }
            System.out.println("Finished. "+dataList.size());
        } catch(Exception e) {
            System.err.println(e);
        }
    }

    public ArrayList<StockData> getList() {
        return dataList;
    }

    @Override
    protected ArrayList<StockData> doInBackground(String... strings) {
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
                String open = subLine[1];
                String high = subLine[2];
                String low = subLine[3];
                String close = subLine[4];
                String volume = subLine[5];
                String adjClose = subLine[6];

                StockData stockData = new StockData(myDate,open,high,low,close,volume,adjClose);
                dataList.add(stockData);
            }
            System.out.println("Finished. "+dataList.size());
        } catch(Exception e) {
            System.err.println(e);
        }
        return dataList;
    }
}

