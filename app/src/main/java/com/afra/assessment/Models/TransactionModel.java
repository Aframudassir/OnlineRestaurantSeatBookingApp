package com.afra.assessment.Models;

public class TransactionModel {
    String date;
    String time;
    String name;
    String pricePerItem;
    String unit;
    String quantity;
    String totalPrice;
    String typeOfTransaction;

    TransactionModel(){
        //Empty Constructor
    }

    @Override
    public String toString() {
        return "TransactionModel{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", pricePerItem='" + pricePerItem + '\'' +
                ", unit='" + unit + '\'' +
                ", quantity='" + quantity + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", typeOfTransaction='" + typeOfTransaction + '\'' +
                '}';
    }
    public TransactionModel(String date, String time, String name, String pricePerItem, String unit, String quantity, String totalPrice, String typeOfTransaction) {
        this.date = date;
        this.time = time;
        this.name = name;
        this.pricePerItem = pricePerItem;
        this.unit = unit;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.typeOfTransaction = typeOfTransaction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(String pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

}
