package com.example.android.easymetrology;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by denisvieira on 11/03/16.
 */
public class CalculatorsListActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.easymetrology.R.layout.activity_calculators_list);
//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        getSupportAc        CollapsingToolbarLayout collapsingToolbar =
//                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);tionBar().setDisplayHomeAsUpEnabled(true);
//         Set Collapsing Toolbar layout to the screen
//
        // Set title of Detail page
//        collapsingToolbar.setTitle("Calculadoras");

    }

    public void onClickToCalculate(View v){
        Context context = v.getContext();
        Intent intent = new Intent(context,CalculateActivity.class);
        startActivity(intent);
    }

}
