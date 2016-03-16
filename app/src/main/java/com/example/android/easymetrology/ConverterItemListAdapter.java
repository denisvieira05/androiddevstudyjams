package com.example.android.easymetrology;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by denisvieira on 15/03/16.
 */
public class ConverterItemListAdapter extends ArrayAdapter<ConverterItem> {

    // View lookup cache
    private static class ViewHolder {
        TextView title;
        TextView description;
    }

    public ConverterItemListAdapter(Context context, ArrayList<ConverterItem> converters) {
        super(context, 0, converters);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ConverterItem item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.converter_item_list, parent, false);
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
