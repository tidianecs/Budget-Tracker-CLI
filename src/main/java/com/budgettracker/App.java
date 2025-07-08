package com.budgettracker;
import java.util.Scanner;

public class App {

    public static void main( String[] args ){
        TransactionFactory factory = new TransactionFactory();
        Scanner scanner = new Scanner(System.in);

        //Just a test but that definitly not the final menu
        System.out.println("=== Budget Tracker ===");
        System.out.print("(Amount) -> ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("( Income / Expense ) -> ");
        String type = scanner.nextLine();
        /*Like i said i use category only for expense so i mada if/else to deal with it
            (THAT'S A PART OF THE FUTURE CODE FOR ADD TRANSACTION)
        */
        if (type.equalsIgnoreCase("expense")) {
            System.out.println("( Food / Car / Phone ) -> ");
            String category = scanner.nextLine();
            Transaction transaction = factory.createTransaction(amount, type, category);
            System.out.println(transaction.showTransaction());
        }else{
            String category = null;
            Transaction transaction = factory.createTransaction(amount, type, category);
            System.out.println(transaction.showTransaction());
        }
    }
}
