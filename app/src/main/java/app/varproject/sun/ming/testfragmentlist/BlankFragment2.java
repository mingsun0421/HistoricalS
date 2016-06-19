package app.varproject.sun.ming.testfragmentlist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {
    private StockDataList stockDataList;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        MainFragment mainFragment = new MainFragment();
        DownloadData downloadData = new DownloadData(mainFragment.getStockName(),null,null);
        stockDataList = new StockDataList("BA");
        ArrayList<StockData> stockDatas = null;
        /*
        new Thread(new Runnable() {
            public void run() {
                stockDataList.DownloadList();
            }
        }).start();
        */
        try {
            stockDatas = stockDataList.execute(new String[]{""}).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(BlankFragment2.this.getActivity(),"Download finished" + stockDatas.size(), Toast.LENGTH_LONG).show();
        CustomAdapter customAdapter = new CustomAdapter(BlankFragment2.this.getActivity(),stockDatas);
        ListView listView = (ListView)view.findViewById(R.id.listview_1);
        listView.setAdapter(customAdapter);

        return view;
    }


}
