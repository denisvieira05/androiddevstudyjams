package com.example.android.easymetrology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.easymetrology.fragments.InchFractionalToInchMilesimalFragment;
import com.example.android.easymetrology.fragments.InchFractionalToMillimeterFragment;
import com.example.android.easymetrology.fragments.InchMilesimalToMillimeterFragment;
import com.example.android.easymetrology.fragments.MillimeterToInchFractionalFragment;
import com.example.android.easymetrology.fragments.MillimeterToInchMIlesimalFragment;

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
            Bundle params = intent.getExtras();
            if(params != null){
                Integer converterId = params.getInt("id");
                FragmentTransaction ft = fm.beginTransaction();

                switch (converterId) {
                    case 1:
                        MillimeterToInchMIlesimalFragment converterFragment1 = new MillimeterToInchMIlesimalFragment();

                        ft.add(R.id.activity_convert,converterFragment1).commit();
                        break;
                    case 2:
                        InchMilesimalToMillimeterFragment converterFragment2 = new InchMilesimalToMillimeterFragment();

                        ft.add(R.id.activity_convert,converterFragment2).commit();
                        break;
                    case 3:
                        InchFractionalToMillimeterFragment converterFragment3 = new InchFractionalToMillimeterFragment();

                        ft.add(R.id.activity_convert,converterFragment3).commit();
                        break;
                    case 4:
                        InchFractionalToInchMilesimalFragment converterFragment4 = new InchFractionalToInchMilesimalFragment();

                        ft.add(R.id.activity_convert,converterFragment4).commit();
                        break;
                    case 5:
                        MillimeterToInchFractionalFragment converterFragment5 = new MillimeterToInchFractionalFragment();

                        ft.add(R.id.activity_convert,converterFragment5).commit();
                        break;
                }

            }

        }
    }


}
