package com.company.models;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Date;

final public class Order {
    private String uid;
    private int tableNumber;
    private ArrayList<Product>products;
    private int discountPercent;

    public Order(String uid, int tableNumber, ArrayList<Product> products) {
        this.uid = uid;
        this.tableNumber = tableNumber;
        this.products = products;
    }

    public double getTotalAmount(){
        double totalAmount= 0;
        for(Product product : this.products){
            totalAmount += product.getTotalPrice();

        }
        if(this.discountPercent > 0){
            return totalAmount-(((double) this.discountPercent /100)* totalAmount);
        }
        return totalAmount;


    }
    public String getTotalAmountString(){
        double totalAmount = getTotalAmount();
        return Double.toString(totalAmount)+ " lv.";
    }
    //public String getTotalAmountStingInEUR(){
      //  double totalAmountInEUR = getTotalAmount() / 1.95;
        //return Double.toString(totalAmountInEUR)+ " EUR";
    //}
    public String getProductCount(){
        int productCount = 0;
        for(Product product : this.products){
            productCount = productCount + product.getCount();

        }
        return Integer.toString(productCount);

    }


    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getUid() {
        return uid;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }
}
