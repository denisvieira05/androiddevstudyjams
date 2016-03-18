package com.example.android.easymetrology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.easymetrology.fragments.ApproachContentFragment;

/**
 * Created by denisvieira on 12/03/16.
 */
public class GuideActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();
            if(params != null){
                String title = params.getString("title");
                String desc = params.getString("desc");

                TextView titleCalculate = (TextView) findViewById(R.id.calculate_title);
                TextView descCalculate = (TextView) findViewById(R.id.calculate_desc);

                titleCalculate.setText(title);
                descCalculate.setText(desc);
            }
        }

        if(savedInstanceState == null){

            Bundle params = intent.getExtras();
            if(params != null){
                Integer calculatorId = params.getInt("id");
                FragmentTransaction ft = fm.beginTransaction();
//
                switch (calculatorId) {
                    case 1:
                        ApproachContentFragment calculateFragment1 = new ApproachContentFragment();
                        ft.add(R.id.activity_calculate, calculateFragment1).commit();
                        break;
                }
            }
        }

//        String[] lista = new String[]("Fragment 1", "Altera Texto Fragment 1", "Fragment 2","Fragment 3");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista);

//        ListView lv = (ListView) findViewById(R.id.listView1);
//        lv.setAdapter(adapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> lv, View view, int position, long id) {
//                if(position == 1){
//
//                    ApproachContentFragment caliperRule = (ApproachContentFragment) fm.findFragmentById(R.id.fragmentCaliperRule);
//                    caliperRule.modifiedTextView("Fragment 1 - TextViewAlterado");
//                }
//            }
//        });

    }

    public static class DebugExampleTwoFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            EditText v = new EditText(getActivity());
            v.setText("Hello Fragment!");
            return v;
        }
    }
}
