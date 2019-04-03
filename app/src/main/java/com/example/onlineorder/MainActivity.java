package com.example.onlineorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    static ArrayList<Item> arrayOfItems;

    //--------------------------------------------------------------------------
    // Initializes the array list, populates the array list with items,
    // and sets up the list view.
    //--------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize array list.
        arrayOfItems = new ArrayList<Item>();

        // Populate array list with items.
        arrayOfItems.add(new Item("Coffee", 1.99, "Beverage"));
        arrayOfItems.add(new Item("Water", 0.99, "Beverage"));
        arrayOfItems.add(new Item("Apple", 1.59, "Food"));
        arrayOfItems.add(new Item("Egg", 5.99, "Food"));
        arrayOfItems.add(new Item("Bagel", 2.99, "Food"));
        arrayOfItems.add(new Item("Salad", 3.99, "Food"));
        arrayOfItems.add(new Item("Bacon", 2.51, "Food"));
        arrayOfItems.add(new Item("Panini", 4.99, "Food"));
        arrayOfItems.add(new Item("Toast", 2.99, "Food"));
        arrayOfItems.add(new Item("Quiche", 6.99, "Food"));
        arrayOfItems.add(new Item("Salmon", 8.99, "Food"));
        arrayOfItems.add(new Item("Yogurt Parfait", 1.99, "Food"));
        arrayOfItems.add(new Item("Banana", 1.79, "Food"));
        arrayOfItems.add(new Item("Creamy Tomato Soup", 4.99, "Food"));
        arrayOfItems.add(new Item("Roast Turkey Breast", 10.99, "Food"));
        arrayOfItems.add(new Item("French Tuna Salad", 9.46, "Food"));
        arrayOfItems.add(new Item("Ham and Swiss Sandwich", 7.95, "Food"));
        arrayOfItems.add(new Item("Turkey Pesto", 6.45, "Food"));
        arrayOfItems.add(new Item("Brie and Honey", 11.99, "Food"));
        arrayOfItems.add(new Item("Autumn Apple & Gruyere", 12.99, "Food"));
        arrayOfItems.add(new Item("California Muffuletta", 8.18, "Food"));

        // Create adapter to convert the array of items to views for list view.
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, arrayOfItems);

        // Attach the adapter to the list view.
        ListView listView = findViewById(R.id.activity_main_list_view);
        listView.setAdapter(adapter);

        // Set on item click listener.
        listView.setOnItemClickListener(this);
    }

    //--------------------------------------------------------------------------
    // Inflates the action bar menu items.
    //--------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //--------------------------------------------------------------------------
    // Action listener for action bar menu items.
    //--------------------------------------------------------------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.action_check_out)
        {
            Intent intent = new Intent(getApplicationContext(), CheckOutActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    //--------------------------------------------------------------------------
    // Click listener for the list view.
    //--------------------------------------------------------------------------
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Intent intent = new Intent(getApplicationContext(), QuantityActivity.class);
        intent.putExtra("position", Integer.toString(position));
        startActivity(intent);
    }
}