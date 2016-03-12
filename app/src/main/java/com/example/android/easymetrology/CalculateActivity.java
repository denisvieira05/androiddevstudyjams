package com.example.android.easymetrology;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by denisvieira on 12/03/16.
 */
public class CalculateActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        if(savedInstanceState == null){
            ApproachContentFragment approach = new ApproachContentFragment();

            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.activity_calculate,approach).commit();
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
