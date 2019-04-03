//---------------------------------------------------------------------
// Item.java
// This class represents an item that someone can order.
//---------------------------------------------------------------------

package com.example.onlineorder;

public class Item
{
    private String name;
    private double priceOfSingleItem;
    private double price;
    private String category;
    private int quantity;

    //--------------------------------------------------------------------------
    // This class initializes an item with a name, price and category.
    //--------------------------------------------------------------------------
    Item(String name, double price, String category)
    {
        this.name = name;
        this.priceOfSingleItem = price;
        this.category = category;
        this.price = 0.00;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceOfSingleItem() {
        return priceOfSingleItem;
    }

    public void setPriceOfSingleItem(double priceOfSingleItem) {
        this.priceOfSingleItem = priceOfSingleItem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
