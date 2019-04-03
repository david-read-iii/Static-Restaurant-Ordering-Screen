package com.example.onlineorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class QuantityActivity extends AppCompatActivity
{
    TextView textViewName;
    TextView textViewPrice;
    TextView textViewQuantity;

    // Item position in the arraylist that this activity is referencing.
    int position;

    // Name, price and quantity of the item being referenced.
    String name;
    double priceOfSingleItem;
    double price;
    int quantity;

    //--------------------------------------------------------------------------
    // Initializes the activity quantity layout with initial text views.
    //--------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);

        // Create intent object to retrieve intent extras from MainActivity.
        Intent intent = getIntent();

        // Retrieve position of the item object being referenced in the arraylist.
        position = Integer.parseInt(intent.getStringExtra("position"));

        // Retrieve name, price and quantity from item object being referenced in this activity.
        name = MainActivity.arrayOfItems.get(position).getName();
        priceOfSingleItem = MainActivity.arrayOfItems.get(position).getPriceOfSingleItem();
        price = MainActivity.arrayOfItems.get(position).getPrice();
        quantity = MainActivity.arrayOfItems.get(position).getQuantity();

        // Set text views in activity quantity layout file.
        textViewName = findViewById(R.id.activity_quantity_text_view_name);
        textViewPrice = findViewById(R.id.activity_quantity_text_view_price);
        textViewQuantity = findViewById(R.id.activity_quantity_text_view_quantity);

        textViewName.setText(name);
        textViewPrice.setText(NumberFormat.getCurrencyInstance().format(price));
        textViewQuantity.setText(Integer.toString(quantity));
    }

    //--------------------------------------------------------------------------
    // Updates the values of the price and quantity text views.
    //--------------------------------------------------------------------------
    private void display()
    {
        textViewPrice.setText(NumberFormat.getCurrencyInstance().format(price));
        textViewQuantity.setText(Integer.toString(quantity));
    }

    //--------------------------------------------------------------------------
    // Decrements the quantity of the item and updates the price and quantity
    // text views.
    //--------------------------------------------------------------------------
    public void decrement(View view)
    {
        if(quantity > 0)
        {
            quantity--;
            price = priceOfSingleItem * quantity;
            display();
        }
    }

    //--------------------------------------------------------------------------
    // Increments the quantity of the item and updates the price and quantity
    // text views.
    //--------------------------------------------------------------------------
    public void increment(View view)
    {
        quantity++;
        price = priceOfSingleItem * quantity;
        display();
    }

    //--------------------------------------------------------------------------
    // Goes back to the main activity.
    //--------------------------------------------------------------------------
    public void cancel(View view)
    {
        super.onBackPressed();
    }

    //--------------------------------------------------------------------------
    // Updates the arraylist and goes back to the main activity.
    //--------------------------------------------------------------------------
    public void add(View view)
    {
        MainActivity.arrayOfItems.get(position).setPrice(price);
        MainActivity.arrayOfItems.get(position).setQuantity(quantity);
        super.onBackPressed();
    }

}
