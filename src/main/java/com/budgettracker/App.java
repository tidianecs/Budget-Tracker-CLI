package com.budgettracker;
import java.util.Scanner;

public class App {

    public static void main( String[] args ){
        TransactionService transactionService = new TransactionService();
        TransactionFactory factory = new TransactionFactory();
        Scanner scanner = new Scanner(System.in);
        int repetition = 0;

        //Just a test but that definitly not the final menu
        while (repetition != 1) {
            System.out.println("====== Budget Tracker ======\n1. Add transaction\n2. Delete transaction\n3. Show transactions\n4. Show expenses by category\n5. Exit\n============================");
            int modeChoice = scanner.nextInt();
            if (modeChoice < 1 && modeChoice > 5) {
                System.out.println("You must choice btw 1-5");
            }else if (modeChoice == 1) {
                System.out.print("(Amount) -> ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("( Income / Expense ) -> ");
                String type = scanner.nextLine();
                if (type.equalsIgnoreCase("expense")) {
                    System.out.print("( Food / Car / Phone ) -> ");
                    String category = scanner.nextLine();
                    Transaction transaction = factory.createTransaction(amount, type, category);
                    transactionService.addTransac(transaction);
                    System.out.println("Total Balance: " + transactionService.getBalance());
                }else{
                    String category = null;
                    Transaction transaction = factory.createTransaction(amount, type, category);
                    transactionService.addTransac(transaction);
                    System.out.println("Total Balance: " + transactionService.getBalance());
                }
            }else if (modeChoice == 2) {
                transactionService.showTransactions();
                System.out.print("Please choose the id of the transaction\n(id) -> ");
                int id = scanner.nextInt();
                transactionService.delTransac(id);
                System.out.println("Total Balance: " + transactionService.getBalance());
            }else if (modeChoice == 3) {
                transactionService.showTransactions();
                System.out.println("Total Balance: " + transactionService.getBalance());
            }else if (modeChoice == 4) {
                scanner.nextLine();
                System.out.print("( Food / Car / Phone ) -> ");
                String category = scanner.nextLine();
                transactionService.showExpenseTransac(category);
                System.out.println("Total Expense Balance: " + transactionService.getExpenceBalance(category));
            }else if (modeChoice == 5) {
                System.out.println("Have a nice day !");
                repetition++;
            }
        }
    }
}
