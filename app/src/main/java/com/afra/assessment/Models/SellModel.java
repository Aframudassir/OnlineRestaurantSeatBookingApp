package com.afra.assessment.Models;

public class SellModel {

    String itemname;

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    int price;

    SellModel(){
        //Empty Constructor
    }

    public SellModel(String itemname, int price) {
        this.itemname = itemname;
        this.price = price;
    }



    @Override
    public String toString() {
        return "SellModel{" +
                "itemname='" + itemname + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
