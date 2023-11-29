package com.project.spring.monthlyexpensestracker.item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;


import java.time.LocalDate;


public class Item {

    private int serialNo;
    @Size(min = 3,message = "Enter atleast 3 characters")
    private String name;
    @Positive(message = "please enter positive number")
    private double price;

    private String username;

    private LocalDate localDate;

    @Positive(message = "please enter positive number")
    private int quantity;

    public Item(String username, int serialNo, String name, double price, LocalDate localDate,int quantity){
        this.username=username;
        this.serialNo=serialNo;
        this.name=name;
        this.price=price;
        this.localDate=localDate;
        this.quantity=quantity;
    }


    public String getName(){
        return  this.name;
    }

    public double getPrice(){
        return  this.price;
    }

    public int getSerialNo(){
        return this.serialNo;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
    public String getUsername() {
        return this.username;
    }

    @Override
    public String toString() {
        return "Item{" +
                "serialNo=" + serialNo +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", username='" + username + '\'' +
                ", localDate=" + localDate +
                ", quantity=" + quantity +
                '}';
    }

    public int getQuantity() {
        return quantity;
    }


    public void setUserName(String userName) {
        this.username=userName;
    }
}
