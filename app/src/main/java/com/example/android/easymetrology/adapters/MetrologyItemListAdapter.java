package com.example.android.easymetrology.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.easymetrology.MetrologyItem;
import com.example.android.easymetrology.R;

import java.util.ArrayList;

/**
 * Created by denisvieira on 15/03/16.
 */
public class MetrologyItemListAdapter extends ArrayAdapter<MetrologyItem> {

    // View lookup cache
    private static class ViewHolder {
        TextView title;
        TextView description;
    }

    public MetrologyItemListAdapter(Context context, ArrayList<MetrologyItem> converters) {
        super(context, 0, converters);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MetrologyItem item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.metrology_item_list, parent, false);
        }
        // Lookup view for data population
        TextView title = (TextView) convertView.findViewById(R.id.list_title);
        TextView description = (TextView) convertView.findViewById(R.id.list_desc);
        // Populate the data into the template view using the data object
        title.setText(item.title);
        description.setText(item.description);
        // Return the completed view to render on screen
        return convertView;
    }

}
