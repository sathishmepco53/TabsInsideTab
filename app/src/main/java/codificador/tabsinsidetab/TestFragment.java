package codificador.tabsinsidetab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Sathish on 8/17/2017.
 */

public class TestFragment extends Fragment{

    TextView textView;
    String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_test, container, false);
        textView = rootView.findViewById(R.id.textView);
        return rootView;
    }

    public void setText(String text){
        this.text = text;
    }

    @Override
    public void onResume() {
        super.onResume();
        textView.setText(text);
    }
}
