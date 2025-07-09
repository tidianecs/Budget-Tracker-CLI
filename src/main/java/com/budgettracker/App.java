package com.budgettracker;
import java.util.Scanner;

public class App {

    public static void main( String[] args ){
        TransactionService transactionService = new TransactionService();
        TransactionFactory factory = new TransactionFactory();
        Scanner scanner = new Scanner(System.in);
        int repetition = 0;

        while (repetition != 1) {
            System.out.println("====== Budget Tracker ======\n1. Add transaction\n2. Delete transaction\n3. Show transactions\n4. Show expenses by category\n5. Exit\n============================");
            //To avoid no int input for the modeChoice
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next();
                continue;
            }

            int modeChoice = scanner.nextInt();
            
            if (modeChoice < 1 || modeChoice > 5) {
                System.out.println("You must choice btw 1-5");
            }
            
            else if (modeChoice == 1) {
                System.out.print("(Amount) -> ");
                //To avoid no double input for the amount
                if (!scanner.hasNextDouble()) {
                    System.out.println("Please enter numbers.");
                    scanner.next();
                    continue;
                }

                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("( Income / Expense ) -> ");
                String type = scanner.nextLine();
                //To avoid all the input that's not our types
                if (!type.equalsIgnoreCase("income") && !type.equalsIgnoreCase("expense")) {
                    System.out.println("Please enter a valid type.");
                    continue;                    
                }

                if (type.equalsIgnoreCase("expense")) {
                    System.out.print("( Food / Car / Phone ) -> ");
                    String category = scanner.nextLine();
                    //To avoid all the input that's not our categories
                    if (!category.equalsIgnoreCase("food") && !category.equalsIgnoreCase("car") && !category.equalsIgnoreCase("phone")) {
                        System.out.println("Please enter valid category.");
                        continue;
                    }

                    Transaction transaction = factory.createTransaction(amount, type, category);
                    transactionService.addTransac(transaction);
                    System.out.println("Total Balance: " + transactionService.getBalance());
                }else{
                    String category = null;
                    Transaction transaction = factory.createTransaction(amount, type, category);
                    transactionService.addTransac(transaction);
                    System.out.println("Total Balance: " + transactionService.getBalance());
                }
            }
            
            else if (modeChoice == 2) {
                transactionService.showTransactions();
                System.out.print("Please choose the id of the transaction\n(id) -> ");
                //To avoid invlad id input
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid ID input.");
                    scanner.next();
                    continue;
                }

                int id = scanner.nextInt();
                transactionService.delTransac(id);
                System.out.println("Total Balance: " + transactionService.getBalance());
            }
            
            else if (modeChoice == 3) {
                transactionService.showTransactions();
                System.out.println("Total Balance: " + transactionService.getBalance());
            }
            
            else if (modeChoice == 4) {
                scanner.nextLine();
                System.out.print("( Food / Car / Phone ) -> ");
                
                if (!scanner.hasNextLine()) {
                    System.out.println("Please enter valid category");
                }
                
                String category = scanner.nextLine();

                //To avoid all the input that's not our categories
                if (!category.equalsIgnoreCase("food") && !category.equalsIgnoreCase("car") && !category.equalsIgnoreCase("phone")) {
                    System.out.println("Please enter valid category.");
                    continue;
                }

                transactionService.showExpenseTransac(category);
                System.out.println("Total Expense Balance: " + transactionService.getExpenceBalance(category));
            }
            
            else if (modeChoice == 5) {
                System.out.println("Have a nice day !");
                repetition++;
            }
        }
    }
}
