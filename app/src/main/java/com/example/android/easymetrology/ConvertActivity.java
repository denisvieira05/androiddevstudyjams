package com.example.android.easymetrology;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by denisvieira on 12/03/16.
 */
public class ConvertActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        if(savedInstanceState == null){
            MillimeterToInchMIlesimalContentFragment approach = new MillimeterToInchMIlesimalContentFragment();

            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.activity_convert,approach).commit();
        }
    }
}
