package com.budgettracker;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;

public class TransactionService {
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Gson gson = new Gson();
    private int id = 0;
    private double balance;
    private double expBalance;

    public TransactionService(){
        loadData();
    }

    public void addTransac(Transaction transaction){
        transaction.setId(id++);
        transactions.add(transaction);
        saveData();
    }

    public void delTransac(int id){
        for(int i = 0; i < transactions.size(); i++){
            if (i == id) {
                transactions.remove(i);
            }
        }saveData();
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

    public void saveData(){
        try(FileWriter writer = new FileWriter("C:\\Users\\hp\\Desktop\\CodingProject\\budgetTrackerCli\\budget_tracker_cli\\src\\main\\java\\com\\budgettracker\\transactions.json")){
            gson.toJson(transactions, writer);
        } catch (IOException error){
            error.printStackTrace();
        }
    }

    public void loadData() {
        try (Reader reader = new FileReader("C:\\Users\\hp\\Desktop\\CodingProject\\budgetTrackerCli\\budget_tracker_cli\\src\\main\\java\\com\\budgettracker\\transactions.json")) {
            File file = new File("C:\\Users\\hp\\Desktop\\CodingProject\\budgetTrackerCli\\budget_tracker_cli\\src\\main\\java\\com\\budgettracker\\transactions.json");

            //if the file is empty
            if (file.length() == 0) {
                transactions = new ArrayList<>();
                return;
            }

            Transaction[] loadedTransac = gson.fromJson(reader, Transaction[].class);
            if (loadedTransac != null) {
                transactions = new ArrayList<>(Arrays.asList(loadedTransac));
                //To get a unique id even if we run quit and come back
                int maxId = 0;
                for(Transaction transaction : transactions){
                    if (transaction.getId() > maxId) {
                        maxId = transaction.getId();
                    }
                }
                id = maxId + 1;
                }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

}
