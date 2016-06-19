package app.varproject.sun.ming.testfragmentlist;

/**
 * Created by GOU on 12/06/2016.
 */

import java.util.ArrayList;

public class HistoricalSimulation {
    private ArrayList<Double> stockReturns;
    private ArrayList<Double> portfolioValues;
    private ArrayList<Double> portfolioPrecents;
    private ArrayList<Double> adjCloses;
    private int RM;
    private String stockName;

    private ArrayList<StockData> stockDataArrayList;
    private StockDataList stockDataList;

    public HistoricalSimulation(int RM, String stockName){
        stockDataList = new StockDataList("BA");
        try {
            stockDataArrayList = stockDataList.execute(new String[]{""}).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        adjCloses = new ArrayList<Double>();
        stockReturns = new ArrayList<Double>();
        portfolioValues = new ArrayList<Double>();
        portfolioPrecents = new ArrayList<Double>();
        this.RM = RM;
    }

    public ArrayList<Double> getStockReturns() {
        for(int index=0; index<stockDataArrayList.size(); index++) {
            adjCloses.add(Double.parseDouble(stockDataArrayList.get(index).getAdjClose()));
        }
        for(int index=0; index<adjCloses.size()-1; index++) {
            double result = Math.log(adjCloses.get(index)/adjCloses.get(index+1));
            stockReturns.add(result);
        }
        return stockReturns;
    }

    public ArrayList<Double> getPortfolioValues() {
        stockReturns = getStockReturns();
        for(int index=0; index<stockReturns.size(); index++) {
            portfolioValues.add(RM*stockReturns.get(index));
        }
        return portfolioValues;
    }

    public ArrayList<Double> getPortfolioPrecents() {
        portfolioValues = getPortfolioValues();
        for(int index=0; index<portfolioValues.size(); index++) {
            portfolioPrecents.add((portfolioValues.get(index)/RM)*100);
        }
        return portfolioPrecents;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
}

