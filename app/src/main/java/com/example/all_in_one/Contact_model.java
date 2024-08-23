package com.example.all_in_one;

public class Contact_model {

    int img;
    String name,number;
    public Contact_model(int img,String name,String number)
    {
        this.img = img;
        this.name = name;
        this.number = number;
    }
    public Contact_model(String name,String number)
    {
        this.name = name;
        this.number = number;
    }
}
