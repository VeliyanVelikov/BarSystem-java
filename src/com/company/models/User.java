package com.company.models;


import java.util.ArrayList;

final public class User {

    private String name;
    private String phone;
    private String pin;
    private UserType type;

    public User(String name, String phone, String pin, UserType type) {
        this.name = name;
        this.phone = phone;
        this.pin = pin;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPin() {
        return pin;
    }

    public UserType getType() {
        return type;
    }

    public String setName() {
        return name;
    }

    public String setPhone() {
        return phone;
    }

    public String setPin() {
        return pin;
    }

    public UserType setType() {
        return type;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPin(String pin){
        this.pin = pin;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setType (UserType type){
        this.type = type;
    }


}






