package com.example.onlineorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<Item>
{
    //--------------------------------------------------------------------------
    // Create a new CustomArrayAdapter with context and an array list as inputs.
    //--------------------------------------------------------------------------
    public CustomArrayAdapter(Context context, ArrayList<Item> items)
    {
        super(context, 0, items);
    }

    //--------------------------------------------------------------------------
    // Converts each Item object stored in the array list to a view that a list
    // view can display.
    //--------------------------------------------------------------------------
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get item for this position.
        Item item = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view.
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main_list_view_single_row, parent, false);
        }

        // Lookup view for data population.
        TextView name = (TextView) convertView.findViewById(R.id.activity_main_list_view_text_view);
        TextView price = (TextView) convertView.findViewById(R.id.activity_main_list_view_text_view_2);

        // Populate the data into the template view using the data object.
        name.setText(item.getName());
        price.setText(NumberFormat.getCurrencyInstance().format(item.getPriceOfSingleItem()));

        // Return the completed view to render on screen.
        return convertView;
    }
}
