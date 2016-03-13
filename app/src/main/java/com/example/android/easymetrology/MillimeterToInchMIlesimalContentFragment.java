package com.example.android.easymetrology;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by denisvieira on 13/03/16.
 */
public class MillimeterToInchMIlesimalContentFragment extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View view = inflater.inflate(R.layout.fragment_millimeter_to_inch_milesimal,null);

//        TextView textv = (TextView) view.findViewById(R.id.textViewCaliperRule);
//        textv.setText("Frament TESTE");

        Button button = (Button) view.findViewById(R.id.convertMillimeterToInchButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView resultView = (TextView) getView().findViewById(R.id.result);
                double result = calcMillimeterToInchMIlesimal();

                DecimalFormat numberFormat = new DecimalFormat("##.###");

                resultView.setText(numberFormat.format(result)+"''");
            }
        });

        return (view);
    }

    public double calcMillimeterToInchMIlesimal(){

        EditText millimeterEditText = (EditText) getView().findViewById(R.id.millimeterValue);

        double millimeterValue = Float.parseFloat(millimeterEditText.getText().toString());
        double dividerMilesimal = 25.4;

        double result = millimeterValue/dividerMilesimal;

        return result;

    }
}
