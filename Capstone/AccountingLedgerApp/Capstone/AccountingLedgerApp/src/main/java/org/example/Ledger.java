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

    public ArrayList<Transactions> listAllItems(){


        try{
            FileInputStream statement = new FileInputStream("src/main/resources/transactions.csv");
            Scanner scanner = new Scanner(statement);

            scanner.nextLine();

            String input2;
            while(scanner.hasNextLine()){
                input2 = scanner.nextLine();
                System.out.println(input2);
            }

        } catch (IOException ss){
            System.out.println("File not found. Let's try again later.");
        }
        return null;
    }

   /* public void addDeposit(ArrayList<Transactions> transactions){
        try{
            FileWriter addDeposit = new FileWriter("src/main/resources/transactions.csv", true);
            String depositLine = transactions.toString();

            addDeposit.write(depositLine);
            addDeposit.close();
        }catch (Exception ex){
            System.out.println("Unable to add item. Let's try again.");
        }
    }*/

    public void addDeposit(){
        System.out.println("What is the date of transaction? Format: YYYY-MM-DD");
        String date = scanner.nextLine();

        System.out.println("What is the time of the transaction? Format: HH:MM:SS");
        String time = scanner.nextLine();

        System.out.println("What is a short description of the transaction?");
        String desc = scanner.nextLine();

        System.out.println("Who is the vendor?");
        String vendor = scanner.nextLine();

        System.out.println("What is the amount?");
        double amount = scanner.nextDouble();

        scanner.nextLine();

        try{
            FileWriter added = new FileWriter("src/main/resources/transactions.csv",true);

            added.write(date + "|" + time + "|" + desc + "|" + vendor + "|" + amount + "\n");
            added.close();

            System.out.println("Your deposit has been made. Thank you.");

        } catch(IOException ee){
            System.out.println("Unable to add deposit. Let's try again later.");
        }
    }

  /*  public void makeAPayment(ArrayList<Transactions> ){
        try{
            FileWriter makePay = new FileWriter("src/main/resources/transactions.csv",true);
            String payLine = transactions.toString();

            makePay.write(payLine);
            makePay.close();

        }catch(IOException ex){
            System.out.println("Unable to make a payment. Let's try again.");
        }
    }*/

    Scanner scanner = new Scanner(System.in);
    public void makeAPayment(){

        System.out.println("What is the date of transaction? Format: YYYY-MM-DD");
        String dDate = scanner.nextLine();

        System.out.println("What is the time of the transaction? Format: HH:MM:SS");
        String dTime = scanner.nextLine();

        System.out.println("What is a short description of the transaction?");
        String dDesc = scanner.nextLine();

        System.out.println("Who is the vendor?");
        String dVendor = scanner.nextLine();

        System.out.println("What was the amount?");
        double dAmount = scanner.nextDouble();

        scanner.nextLine();

        try{
            FileWriter payment = new FileWriter("src/main/resources/transactions.csv",true);

            payment.write(dDate + "|" + dTime + "|" + dDesc + "|" + dVendor + "|" + dAmount + "\n");
            payment.close();

            System.out.println("Your payment has been added. Thank you.");
        }
        catch (IOException ex){
            System.out.println("Unable to add payment. Let's try again later.");
        }
    }

    public void showDeposit(ArrayList<Transactions> transactions){ //only entries that are deposits into the account
        for(Transactions sd: transactions){
            if(sd.getAmount() >= 1){
                System.out.printf("Date: %s  | Time: %s  | Description: %s  | Vendor: %s  | Amount: %s ",
                        sd.getDate(), sd.getTime(), sd.getDesc(), sd.getVendor(), sd.getAmount());
            }
        }
    }

    public void showPayments(ArrayList<Transactions> transactions){ //only negative entries
        for(Transactions sp: transactions){
            if(sp.getAmount() <= 0){
                System.out.printf("Date: %s  | Time: %s  | Description: %s  | Vendor: %s  | Amount: %s ",
                        sp.getDate(), sp.getTime(), sp.getDesc(), sp.getVendor(), sp.getAmount());
            }
        }

    }
}