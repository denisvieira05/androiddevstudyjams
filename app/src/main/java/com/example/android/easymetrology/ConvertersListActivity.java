package com.example.android.easymetrology;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.easymetrology.adapters.MetrologyItemListAdapter;

import java.util.ArrayList;

/**
 * Created by denisvieira on 11/03/16.
 */
public class ConvertersListActivity extends AppCompatActivity{

    public static final int CONSTANTE_TELA_1 = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.easymetrology.R.layout.activity_converters_list);
        populateConvertersList();
    }

    private void populateConvertersList() {
        // Construct the data source
        ArrayList<MetrologyItem> arrayOfconverters = MetrologyItem.getConverters();

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,converters);

        // Create the adapter to convert the array to views
        MetrologyItemListAdapter adapter = new MetrologyItemListAdapter(this,arrayOfconverters);

        // Attach the adapter to a ListView
        ListView lv = (ListView) findViewById(R.id.converters_list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int position, long id) {

                Context context = v.getContext();

                // When clicked, show a toast with the TextView text
                MetrologyItem converter = (MetrologyItem) av.getItemAtPosition(position);
//                Toast.makeText(getApplicationContext(),
//                        "Clicked on Row: " + converter.getTitle(),
//                        Toast.LENGTH_LONG).show();

                Bundle params = new Bundle();

                params.putInt("id", converter.getId());
                params.putString("title", converter.getTitle());
                params.putString("desc", converter.getDescription());

                Intent intentOnClick = new Intent(context,ConvertActivity.class);
                intentOnClick.putExtras(params);
                startActivityForResult(intentOnClick, CONSTANTE_TELA_1);

            }
        });

    }


}
