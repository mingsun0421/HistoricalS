package app.varproject.sun.ming.testfragmentlist;

/**
 * Created by GOU on 12/06/2016.
 */


public class StockData {
    private MyDate date;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String adjClose;

    public StockData() {

    }

    public StockData(MyDate date, String open, String high, String low, String close, String volume, String adjClose) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.adjClose = adjClose;
    }

    public MyDate getDate() {
        return date;
    }
    public String getOpen() {
        return open;
    }
    public String getHigh() {
        return high;
    }
    public String getLow() {
        return low;
    }
    public String getClose() {
        return close;
    }
    public String getVolume() {
        return volume;
    }
    public String getAdjClose() {
        return adjClose;
    }
}

