package com.example.android.easymetrology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by denisvieira on 12/03/16.
 */
public class ConvertActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();
            if(params != null){
                String title = params.getString("title");
                String desc = params.getString("desc");

                TextView titleConvert = (TextView) findViewById(R.id.convert_title);
                TextView descConvert = (TextView) findViewById(R.id.convert_desc);

                titleConvert.setText(title);
                descConvert.setText(desc);
            }
        }

        if(savedInstanceState == null){
            MillimeterToInchMIlesimalContentFragment approach = new MillimeterToInchMIlesimalContentFragment();

            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.activity_convert,approach).commit();
        }
    }


}
