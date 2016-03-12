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
                TextView resultApproach = (TextView) getView().findViewById(R.id.resultApproach);
                float result = calcApproach();

                resultApproach.setText("APROXIMAÇÃO \n"+result+"mm");
            }
        });

        return (view);
    }
//
//    public void modifiedTextView(String text){
//        TextView tv = (TextView) getView().findViewById(R.id.textViewCaliperRule);
//        tv.setText("Fragmento modificado");
//    }

    public float calcApproach(){

        EditText valorDivisoesDoNonio = (EditText) getView().findViewById(R.id.valorDivisoesDoNonio);
        EditText valorEscalaPrincipal = (EditText) getView().findViewById(R.id.valorEscalaPrincipal);

        float valorDivisoes = Integer.parseInt(valorDivisoesDoNonio.getText().toString());
        float valorEscala = Integer.parseInt(valorEscalaPrincipal.getText().toString());

        float result = valorEscala/valorDivisoes;

        return result;

    }
}
