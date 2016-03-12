package com.example.android.easymetrology;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by denisvieira on 12/03/16.
 */
public class ApproachContentFragment extends Fragment{

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View view = inflater.inflate(R.layout.fragment_approach,null);

//        TextView textv = (TextView) view.findViewById(R.id.textViewCaliperRule);
//        textv.setText("Frament TESTE");

        return (view);
    }
//
//    public void modifiedTextView(String text){
//        TextView tv = (TextView) getView().findViewById(R.id.textViewCaliperRule);
//        tv.setText("Fragmento modificado");
//    }

    public void calcApproach(){

        TextView resultApproach = (TextView) getView().findViewById(R.id.resultApproach);
        EditText valorDivisoesDoNonio = (EditText) getView().findViewById(R.id.valorDivisoesDoNonio);
        EditText valorEscalaPrincipal = (EditText) getView().findViewById(R.id.valorEscalaPrincipal);

        float valorDivisoes = Integer.parseInt(valorDivisoesDoNonio.getText().toString());
        float valorEscala = Integer.parseInt(valorEscalaPrincipal.getText().toString());

        float result = valorEscala/valorDivisoes;

        resultApproach.setText(String.valueOf("APROXIMAÇÃO\\n"+result+"mm"));

    }
}
