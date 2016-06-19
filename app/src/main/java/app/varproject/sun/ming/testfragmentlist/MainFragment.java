package app.varproject.sun.ming.testfragmentlist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private String stockName;
    public MainFragment() {
        // Required empty public constructor
        stockName = "BA";
    }

    EditText editText;
    Button btnSubmit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        editText = (EditText)view.findViewById(R.id.editText);
        btnSubmit = (Button)view.findViewById(R.id.button);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stockName = editText.getText().toString();
                Toast.makeText(MainFragment.this.getActivity(),"Stock "+stockName+" Submitted", Toast.LENGTH_LONG).show();
            }
        });

        DownloadData downloadData = new DownloadData(stockName, null, null);
        return view;
    }

    public String getStockName() {
        return stockName;
    }

}
