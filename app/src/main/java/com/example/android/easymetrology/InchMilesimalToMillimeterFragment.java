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
 * Created by denisvieira on 16/03/16.
 */
public class InchMilesimalToMillimeterFragment extends Fragment{

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View view = inflater.inflate(R.layout.fragment_inch_milesimal_to_millimeter,null);

//        TextView textv = (TextView) view.findViewById(R.id.textViewCaliperRule);
//        textv.setText("Frament TESTE");

        Button button = (Button) view.findViewById(R.id.convertButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView resultView = (TextView) getView().findViewById(R.id.result);
                double result = calcInchMIlesimalToMillimeter();

                DecimalFormat numberFormat = new DecimalFormat("##.###");

                resultView.setText(numberFormat.format(result)+"mm");
            }
        });

        return (view);
    }

    public double calcInchMIlesimalToMillimeter(){

        EditText millimeterEditText = (EditText) getView().findViewById(R.id.valueToConvert);

        double millimeterValue = Float.parseFloat(millimeterEditText.getText().toString());
        double constOfOperation = 25.4;

        double result = millimeterValue*constOfOperation;

        return result;

    }
}
