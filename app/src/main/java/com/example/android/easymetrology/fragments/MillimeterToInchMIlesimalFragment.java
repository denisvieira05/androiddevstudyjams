package com.example.android.easymetrology.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.easymetrology.R;

import java.text.DecimalFormat;

/**
 * Created by denisvieira on 13/03/16.
 */
public class MillimeterToInchMIlesimalFragment extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View view = inflater.inflate(R.layout.fragment_millimeter_to_inch_milesimal,null);


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
                    double result = calcMillimeterToInchMIlesimal(millimeterEditText);

                    DecimalFormat numberFormat = new DecimalFormat("##.###");

                    resultView.setText(numberFormat.format(result)+"''");

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

            }
        });

        return (view);
    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {

            return false;
        }

        return true;
    }

    public double calcMillimeterToInchMIlesimal(EditText millimeterEditText){

        double millimeterValue = Float.parseFloat(millimeterEditText.getText().toString());
        double dividerMilesimal = 25.4;

        double result = millimeterValue/dividerMilesimal;

        return result;

    }
}
