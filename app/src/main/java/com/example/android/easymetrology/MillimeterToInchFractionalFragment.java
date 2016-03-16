package com.example.android.easymetrology;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by denisvieira on 16/03/16.
 */
public class MillimeterToInchFractionalFragment extends Fragment{
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View view = inflater.inflate(R.layout.fragment_millimeter_to_inch_fractional,null);


        Button button = (Button) view.findViewById(R.id.convertButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView resultView = (TextView) getView().findViewById(R.id.result);
                String result = calcMillimeterToInchFractional();

//                DecimalFormat numberFormat = new DecimalFormat("##.###");

                resultView.setText(result);
            }
        });

        return (view);
    }

    public String calcMillimeterToInchFractional(){

        EditText millimeterEditText = (EditText) getView().findViewById(R.id.valueToConvert);


        double millimeterValue = Float.parseFloat(millimeterEditText.getText().toString());

        double constToConvert = 5.04;

        double multiplicationResult = millimeterValue*constToConvert;

        float millimeterValueMultiplied = (float) multiplicationResult;

        int millimeterValueRounded = Math.round(millimeterValueMultiplied);

        int gcd = gcd(millimeterValueRounded, 128);

        int numerator = millimeterValueRounded/gcd;
        int denominator = 128/gcd;

        String result = numerator+"''\n___\n"+denominator;

        return result;

    }

    static int gcd(int a, int b)
    {
        while(a!=0 && b!=0) // until either one of them is 0
        {
            int c = b;
            b = a%b;
            a = c;
        }
        return a+b; // either one is 0, so return the non-zero value
    }
}
