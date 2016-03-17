package com.example.android.easymetrology;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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


                EditText millimeterEditText = (EditText) getView().findViewById(R.id.valueToConvert);

                boolean hasValue = hasText(millimeterEditText);

                if(hasValue == true){

                    TextView resultView = (TextView) getView().findViewById(R.id.result);
                    String result = calcMillimeterToInchFractional(millimeterEditText);

                    resultView.setText(result);

                }else{
                    // 1. Instantiate an AlertDialog.Builder with its constructor
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                    // 2. Chain together various setter methods to set the dialog characteristics
                    builder.setMessage("Por favor, preencha os campos e tente novamente .")
                            .setTitle("Campo Vazio");

                    // 3. Get the AlertDialog from create()
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
//
////                DecimalFormat numberFormat = new DecimalFormat("##.###");


            }
        });

        return (view);
    }

    public String calcMillimeterToInchFractional(EditText millimeterEditText){

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


    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        Log.d("hasText: ",text);

        // length 0 means there is no text
        if (text.length() == 0) {

            return false;
        }

        return true;
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
