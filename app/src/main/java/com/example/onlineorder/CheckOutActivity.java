package com.example.onlineorder;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CheckOutActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<Item> arrayOfItems;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        arrayOfItems = MainActivity.arrayOfItems;

        // Create adapter to convert the array of items to views for list view.
        CustomArrayAdapter2 adapter = new CustomArrayAdapter2(this, arrayOfItems);

        // Attach the adapter to the list view.
        ListView listView = findViewById(R.id.activity_check_out_list_view);
        listView.setAdapter(adapter);

        for (int i = 0; i < arrayOfItems.size(); i++)
            total += arrayOfItems.get(i).getPrice();

        TextView textView = findViewById(R.id.activity_check_out_text_view_total);
        textView.setText("Total: " + NumberFormat.getCurrencyInstance().format(total));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

    }

    public void editOrder(View view)
    {
        super.onBackPressed();
    }

    public void order(View view)
    {
        Toast.makeText(this, "Order submitted!", Toast.LENGTH_SHORT).show();
        for (int i = 0; i < arrayOfItems.size(); i++)
        {
            arrayOfItems.get(i).setQuantity(0);
            arrayOfItems.get(i).setPrice(0.00);
        }
        MainActivity.arrayOfItems = arrayOfItems;
        super.onBackPressed();
    }
}
