package com.example.android.easymetrology;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.easymetrology.R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(com.example.android.easymetrology.R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(com.example.android.easymetrology.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Denis Vieira. All Rights Reserved \nhttps://github.com/fromdenisvieira", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public void onClickToCalculate(View v){
        Context context = v.getContext();
        Intent intent = new Intent(context,CalculateActivity.class);
        startActivity(intent);
    }

    public void onClickToConverter(View v){
        Context context = v.getContext();
        Intent intent = new Intent(context,ConverterActivity.class);
        startActivity(intent);
    }

    public void onClickToLibrary(View v){
        Context context = v.getContext();
        Intent intent = new Intent(context,LibraryActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.android.easymetrology.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.example.android.easymetrology.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
