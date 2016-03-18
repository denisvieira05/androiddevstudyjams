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
public class GuidesListActivity extends AppCompatActivity {

    public static final int CONSTANTE_TELA_2 = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.easymetrology.R.layout.activity_guides_list);
//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        getSupportAc        CollapsingToolbarLayout collapsingToolbar =
//                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);tionBar().setDisplayHomeAsUpEnabled(true);
//         Set Collapsing Toolbar layout to the screen
//
        // Set title of Detail page
//        collapsingToolbar.setTitle("Calculadoras");

        populateCalculatorsList();

    }

    private void populateCalculatorsList() {
        // Construct the data source
        ArrayList<MetrologyItem> arrayOfcalculators = MetrologyItem.getCalculators();

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,converters);

        // Create the adapter to convert the array to views
        MetrologyItemListAdapter adapter = new MetrologyItemListAdapter(this,arrayOfcalculators);

        // Attach the adapter to a ListView
        ListView lv = (ListView) findViewById(R.id.calculators_list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int position, long id) {

                Context context = v.getContext();

                // When clicked, show a toast with the TextView text
                MetrologyItem calculator = (MetrologyItem) av.getItemAtPosition(position);
//                Toast.makeText(getApplicationContext(),
//                        "Clicked on Row: " + calculator.getTitle(),
//                        Toast.LENGTH_LONG).show();

                Bundle params = new Bundle();

                params.putInt("id", calculator.getId());
                params.putString("title", calculator.getTitle());
                params.putString("desc", calculator.getDescription());

                Intent intentOnClick = new Intent(context, GuideActivity.class);
                intentOnClick.putExtras(params);
                startActivityForResult(intentOnClick, CONSTANTE_TELA_2);

            }
        });

    }

}
