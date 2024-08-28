package com.company.models;

final public class Product {

    private String uid;
    private ProductType type;
    private String subtype;
    private String brand;
    private double price;
    private int quantity;
    private int count;

    public Product(String uid, ProductType type, String subtype, String brand, double price, int quantity) {
        this.uid = uid;
        this.type = type;
        this.subtype = subtype;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.count = 1; // stoinost po podrazbirane

    }
    public String getProductName(){
        if(this.subtype.isEmpty()) {
            return this.brand;
        }

        return this.subtype + " " + this.brand;
    }

    public double getTotalPrice(){
        return Math.round(this.count * this.price * 100.0) / 100.0;

    }
    public void increaseProductCount(){

        this.count = this.count +1;
    }
    public void decreaseProductCount(){

        this.count = this.count-1;
    }

    public String getTotalPriceString(){
        return Double.toString(getTotalPrice()) + "lv.";
    }

    public String getFullPrice(){
        return this.price+ " lv.";
    }

    public String getUid() {
        return uid;
    }

    public ProductType getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCount() {
        return count;
    }
    public String getCountString(){
        return Integer.toString(this.count);
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
