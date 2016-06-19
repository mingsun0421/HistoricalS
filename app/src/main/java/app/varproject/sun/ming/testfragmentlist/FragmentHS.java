package app.varproject.sun.ming.testfragmentlist;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHS extends Fragment {

    private ArrayList<Double> portfolioPrecents;
    private HistoricalSimulation historicalSimulation;
    private int[] xaxis;
    private DataPoint[] dataPoints;
    private int[] counts;

    public FragmentHS() {
        // Required empty public constructor
        xaxis = new int[30];
        dataPoints = new DataPoint[30];
        counts = new int[30];
    }

    private DataPoint[] generateGraph() {
        portfolioPrecents = new ArrayList<Double>();
        historicalSimulation = new HistoricalSimulation(1000, "BA");
        portfolioPrecents = historicalSimulation.getPortfolioPrecents();
        int number = -15;
        for(int index=0; index<30; index++) {
            xaxis[index] = number;
            number = number + 1;
            counts[index] = 0;
        }

        for(int index=0; index<portfolioPrecents.size(); index++) {
            double value = portfolioPrecents.get(index);
            if(value <= -15) {
                counts[0] = counts[0] + 1;
            } else if(value > -15 && value <= -14) {
                counts[1] = counts[1] + 1;
            }else if(value > -14 && value <= -13) {
                counts[2] = counts[2] + 1;
            }else if(value > -13 && value <= -12) {
                counts[3] = counts[3] + 1;
            }else if(value > -12 && value <= -11) {
                counts[4] = counts[4] + 1;
            }else if(value > -11 && value <= -10) {
                counts[5] = counts[5] + 1;
            }else if(value > -10 && value <= -9) {
                counts[6] = counts[6] + 1;
            }else if(value > -9 && value <= -8) {
                counts[7] = counts[7] + 1;
            }else if(value > -8 && value <= -7) {
                counts[8] = counts[8] + 1;
            }else if(value > -7 && value <= -6) {
                counts[9] = counts[9] + 1;
            }else if(value > -6 && value <= -5) {
                counts[10] = counts[10] + 1;
            }else if(value > -5 && value <= -4) {
                counts[11] = counts[11] + 1;
            }else if(value > -4 && value <= -3) {
                counts[12] = counts[11] + 1;
            }else if(value > -3 && value <= -2) {
                counts[13] = counts[13] + 1;
            }else if(value > -2 && value <= -1) {
                counts[14] = counts[14] + 1;
            }else if(value > -1 && value <= 0) {
                counts[15] = counts[15] + 1;
            }else if(value > 0 && value <= 1) {
                counts[16] = counts[16] + 1;
            }else if(value > 1 && value <= 2) {
                counts[17] = counts[17] + 1;
            }else if(value > 2 && value <= 3) {
                counts[18] = counts[18] + 1;
            }else if(value > 3 && value <= 4) {
                counts[19] = counts[19] + 1;
            }else if(value > 4 && value <= 5) {
                counts[20] = counts[20] + 1;
            }else if(value > 5 && value <= 6) {
                counts[21] = counts[21] + 1;
            }else if(value > 6 && value <= 7) {
                counts[22] = counts[22] + 1;
            }else if(value > 7 && value <= 8) {
                counts[23] = counts[23] + 1;
            }else if(value > 8 && value <= 9) {
                counts[24] = counts[24] + 1;
            }else if(value > 9 && value <= 10) {
                counts[25] = counts[25] + 1;
            }else if(value > 10 && value <= 11) {
                counts[26] = counts[26] + 1;
            }else if(value > 11 && value <= 12) {
                counts[27] = counts[27] + 1;
            }else if(value > 12 && value <= 13) {
                counts[28] = counts[28] + 1;
            } else {
                counts[29] = counts[29] + 1;
            }
        }

        for(int index=0; index<30; index++) {
            dataPoints[index] = new DataPoint(xaxis[index],counts[index]);
        }

        for(int i=0;i<30;i++) {
            System.out.println(xaxis[i]+" "+counts[i]);
        }
        return dataPoints;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedIstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_h, container, false);
        GraphView graphView = (GraphView) view.findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(generateGraph());
        graphView.addSeries(series);
        return view;
    }

}
