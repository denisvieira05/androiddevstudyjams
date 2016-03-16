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
public class InchFractionalToMillimeterFragment extends Fragment{
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View view = inflater.inflate(R.layout.fragment_inch_fractional_to_millimeter,null);


        Button button = (Button) view.findViewById(R.id.convertButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView resultView = (TextView) getView().findViewById(R.id.result);
                double result = calcInchFractionalToMillimeter();

                DecimalFormat numberFormat = new DecimalFormat("##.###");

                resultView.setText(numberFormat.format(result)+"mm");
            }
        });

        return (view);
    }

    public double calcInchFractionalToMillimeter(){

        EditText numeratorEditText = (EditText) getView().findViewById(R.id.valueToConvertNumerator);
        EditText denominatorEditText = (EditText) getView().findViewById(R.id.valueToConvertDenominator);

        double numerator = Float.parseFloat(numeratorEditText.getText().toString());
        double denominator = Float.parseFloat(denominatorEditText.getText().toString());
        double constOfConvert = 25.4;

        double result = (numerator*constOfConvert)/denominator;

        return result;

    }
}
