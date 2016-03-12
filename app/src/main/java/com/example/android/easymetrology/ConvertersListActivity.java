package com.example.android.easymetrology;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by denisvieira on 11/03/16.
 */
public class ConvertersListActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.easymetrology.R.layout.activity_converters_list);
    }

    public void onClickToConvert(View v){
        Context context = v.getContext();
        Intent intent = new Intent(context,ConvertActivity.class);
        startActivity(intent);
    }

}
