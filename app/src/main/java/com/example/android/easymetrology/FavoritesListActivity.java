package com.example.android.easymetrology;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by denisvieira on 11/03/16.
 */
public class FavoritesListActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.easymetrology.R.layout.activity_favorites_list);
    }

    public void onClickToCalculations(View v){
        Context context = v.getContext();
        Intent intent = new Intent(context,GuideActivity.class);
        startActivity(intent);
    }
}
