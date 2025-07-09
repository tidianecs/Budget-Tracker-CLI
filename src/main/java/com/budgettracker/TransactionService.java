package com.budgettracker;
import java.util.ArrayList;

public class TransactionService {
    private ArrayList<Transaction> transactions = new ArrayList<>();
    /*private ArrayList<Transaction> foodExpenses = new ArrayList<>();
    private ArrayList<Transaction> carExpenses = new ArrayList<>();
    private ArrayList<Transaction> phoneExpenses = new ArrayList<>();
    */private double balance;
    private double expBalance;

    public void addTransac(Transaction transaction){
        transactions.add(transaction);

        /*if (transaction.getType().equalsIgnoreCase("expense")) {
            switch (transaction.getCategory()) {
                case "food" -> foodExpenses.add(transaction);
                case "car" -> carExpenses.add(transaction);
                case "phone" -> phoneExpenses.add(transaction);
            }*/
    }

    public void delTransac(int id){
        for(int i = 0; i < transactions.size(); i++){
            if (i == id) {
                transactions.remove(i);

                /*if (transactions.get(i).getType().equalsIgnoreCase("expense")) {
                    switch (transactions.get(i).getCategory()) {
                        case "food" -> foodExpenses.remove(transactions.get(i));
                        case "car" -> carExpenses.remove(transactions.get(i));
                        case "phone" -> phoneExpenses.remove(transactions.get(i));
                    }
                */
            }
        }
    }
    

    public double getBalance(){
        balance = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("income")) {
                balance += transaction.getAmount();
            }else if (transaction.getType().equalsIgnoreCase("expense")) {
                balance -= transaction.getAmount();
            }else{
                balance = 0;
            }
        }
        return balance;
    }

    public void showTransactions(){
        for (Transaction transaction : transactions) {
            System.out.println("[" + transaction.getType().toUpperCase() + "]" + " | " + transaction.getAmount() + " | " + transaction.getCategory() + " | " + transaction.getDate() + " | (" + transaction.getId() + ")");
        }
    }

    public void showExpenseTransac(String category){
        for(Transaction transaction : transactions){
            if (transaction.getType().equalsIgnoreCase("expense") && transaction.getCategory().equalsIgnoreCase(category)) {
                System.out.println("[" + transaction.getType().toUpperCase() + "]" + " | " + transaction.getAmount() + " | " + transaction.getCategory() + " | " + transaction.getDate() + " | (" + transaction.getId() + ")");
            }
        }
    }

    public double getExpenceBalance(String category){
        expBalance = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("expense") && transaction.getCategory().equalsIgnoreCase(category) ) {
                expBalance += transaction.getAmount();
            }
        }
        return expBalance;
    }
}
