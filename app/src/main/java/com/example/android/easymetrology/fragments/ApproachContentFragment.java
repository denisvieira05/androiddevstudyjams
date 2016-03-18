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

/**
 * Created by denisvieira on 12/03/16.
 */
public class ApproachContentFragment extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View view = inflater.inflate(R.layout.fragment_approach,null);

//        TextView textv = (TextView) view.findViewById(R.id.textViewCaliperRule);
//        textv.setText("Frament TESTE");

        Button button = (Button) view.findViewById(R.id.calculateApproachButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                EditText valorDivisoesDoNonio = (EditText) getView().findViewById(R.id.valorDivisoesDoNonio);
                EditText valorEscalaPrincipal = (EditText) getView().findViewById(R.id.valorEscalaPrincipal);

                boolean hasValueInNonio = hasText(valorDivisoesDoNonio);
                boolean hasValueInEscala = hasText(valorEscalaPrincipal);

                if(hasValueInNonio == true &&  hasValueInEscala == true){

                    TextView resultApproach = (TextView) getView().findViewById(R.id.resultApproach);
                    float result = calcApproach(valorDivisoesDoNonio,valorEscalaPrincipal);

                    resultApproach.setText("APROXIMAÇÃO \n"+result+"mm");

                }else{
                    // 1. Instantiate an AlertDialog.Builder with its constructor
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                    // 2. Chain together various setter methods to set the dialog characteristics
                    builder.setMessage("Por favor, preencha todos os campos e tente novamente .")
                            .setTitle("Campo Vazio");

                    // 3. Get the AlertDialog from create()
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }


            }
        });

        return (view);
    }
//
//    public void modifiedTextView(String text){
//        TextView tv = (TextView) getView().findViewById(R.id.textViewCaliperRule);
//        tv.setText("Fragmento modificado");
//    }

    public float calcApproach(EditText valorDivisoesDoNonio, EditText valorEscalaPrincipal){

        float valorDivisoes = Float.parseFloat(valorDivisoesDoNonio.getText().toString());
        float valorEscala = Float.parseFloat(valorEscalaPrincipal.getText().toString());

        float result = valorEscala/valorDivisoes;

        return result;

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
}
