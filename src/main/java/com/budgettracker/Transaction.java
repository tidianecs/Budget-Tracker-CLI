package com.budgettracker;
import java.time.LocalDate;


public class Transaction {
    private static int counter = -1;
    private int id;
    private double amount;
    private String type;
    private String category;
    private LocalDate date;

    Transaction(double amount, String type, String category){
        this.id = ++counter;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.date = LocalDate.now();
    }

    //set and get methods
    public int getId(){
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }
}
