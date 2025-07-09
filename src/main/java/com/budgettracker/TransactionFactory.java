package com.budgettracker;

public class TransactionFactory {
    Transaction createTransaction(double amount, String type, String category){
        //Income doesn't got a category, i only use it for expense
        if (type.equalsIgnoreCase("income")) {
            category = "-";
        }/*else if (type.equalsIgnoreCase("expense") && category.equalsIgnoreCase("food") | category.equalsIgnoreCase("car") | category.equalsIgnoreCase("phone")) {
            
        }*/
        return new Transaction(amount, type, category);
    }
}
