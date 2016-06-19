package app.varproject.sun.ming.testfragmentlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GOU on 12/06/2016.
 */

public class CustomAdapter extends ArrayAdapter<StockData> {

    public CustomAdapter(Context context, ArrayList<StockData> dataList) {
        super(context, R.layout.list_item, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customer = layoutInflater.inflate(R.layout.list_item, parent, false);
        StockData stockData = getItem(position);
        TextView textViewOpen = (TextView)customer.findViewById(R.id.textViewOpen);
        TextView textViewHigh = (TextView)customer.findViewById(R.id.textViewHigh);
        TextView textViewLow = (TextView)customer.findViewById(R.id.textViewLow);
        TextView textViewDate = (TextView)customer.findViewById(R.id.textViewDate);
        TextView textViewVolume = (TextView)customer.findViewById(R.id.textViewVolume);
        TextView textViewAdj= (TextView)customer.findViewById(R.id.textViewAdj);
        TextView textViewClose = (TextView)customer.findViewById(R.id.textViewClose);


        textViewOpen.setText(stockData.getOpen());
        textViewHigh.setText(stockData.getHigh());
        textViewLow.setText(stockData.getLow());
        textViewDate.setText(stockData.getDate().toString());
        textViewVolume.setText(stockData.getVolume());
        textViewAdj.setText(stockData.getAdjClose());
        textViewClose.setText(stockData.getClose());

        return customer;
    }
}
