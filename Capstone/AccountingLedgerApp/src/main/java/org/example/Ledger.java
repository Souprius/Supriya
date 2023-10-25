package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {

    public ArrayList<Transactions> showAllItems() {
        ArrayList<Transactions> transactions = new ArrayList<>();

        try {
            FileInputStream bank = new FileInputStream("src/main/resources/transactions.csv");
            Scanner scanner = new Scanner(bank);

            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] transaction = line.split("\\|");

                String date = transaction[0];
                String time = transaction[1];
                String desc = transaction[2];
                String vendor = transaction[3];
                double amount = Double.parseDouble(transaction[4]);

                Transactions newAction = new Transactions(date, time, desc, vendor, amount);
                transactions.add(newAction);
            }
            for (Transactions action : transactions) {
                System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: %.2f %n",
                        action.getDate(), action.getTime(), action.getDesc(), action.getVendor(), action.getAmount());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find transactions. Let's try again later.");
        }
        return transactions;
    }

    public static void addDeposit(Transactions transactions){
        try{
            FileWriter addDeposit = new FileWriter("src/main/resources/transactions.csv", true);
            String depositLine = transactions.toString();

            addDeposit.write(depositLine);
            addDeposit.close();
        }catch (Exception ex){
            System.out.println("Unable to add item. Let's try again.");
        }
    }

    public static void makeAPayment(Transactions transactions){
        try{
            FileWriter makePay = new FileWriter("src/main/resources/transactions.csv",true);
            String payLine = transactions.toString();

            makePay.write(payLine);
            makePay.close();

        }catch(IOException ex){
            System.out.println("Unable to make a payment. Let's try again.");
        }
    }

    public void showDeposit(){ //only entries that are deposits into the account
        for(Transactions sd: transactions){
            if(sd.getAmount() >= 1){
                System.out.printf("Date: %s  | Time: %s  | Description: %s  | Vendor: %s  | Amount: %s ",
                        sd.getDate(), sd.getTime(), sd.getDesc(), sd.getVendor(), sd.getAmount());
            }
        }
    }

    public void showPayments(){ //only negative entries
        for(Transactions sp: transactions){
            if(sp.getAmount() <= 0){
                System.out.printf("Date: %s  | Time: %s  | Description: %s  | Vendor: %s  | Amount: %s ",
                        sp.getDate(), sp.getTime(), sp.getDesc(), sp.getVendor(), sp.getAmount());
            }
        }

    }
}