package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class UserInterface {
    Ledger l = new Ledger();

    public void homeOptions(){
    Scanner scanner = new Scanner(System.in);

    Ledger statement = new Ledger();

    boolean banking = true;
    while(banking){
        System.out.println(" --- Home --- ");
        System.out.println("Please select an option (D, P, L, X) from the list below.");
        System.out.println("D - Add Deposit");
        System.out.println("P - Make a Payment");
        System.out.println("L - Open Ledger");
        System.out.println("X - Exit");
        String userInput = scanner.nextLine();

        try{
            switch(userInput){
                case "D":
                    statement.addDeposit();
                    break;
                case "P":
                    statement.makeAPayment();
                    break;
                case "L":
                    displayLedgerScreen();
                    break;
                case "X":
                    System.out.println("Thank you for using our app!");
                    System.exit(0);
                    banking = false;
                    break;
                default:
                    System.out.println("Please select a valid option.");
                    break;
            }

        }catch(Exception ex){
            System.out.println("Please select a valid option.");
        }
    }
}

public void displayLedgerScreen(){
    Scanner scanner = new Scanner(System.in);

    Ledger ledger = new Ledger();

    boolean viewingLedger = true;
    while(viewingLedger){
        System.out.println(" --- Ledger Home --- ");
        System.out.println("Please select an option (A, D, P, R, H) from the list below.");
        System.out.println("A - Show All");
        System.out.println("D - Show Deposits");
        System.out.println("P - Show Payments");
        System.out.println("R - Reporting");
        System.out.println("H - Home");
        String userInput2 = scanner.nextLine();

        System.out.println(userInput2);
        try{
            switch(userInput2){
                case "A":
                    ledger.showAllItems();
                    break;
                case "D":
                    ledger.showDeposit(l.listAllItems());
                    break;
                case "P":
                    ledger.showPayments(l.listAllItems());
                    break;
                case "R":
                    displayReportingScreen();
                    break;
                case "H":
                    homeOptions();
                    viewingLedger = false;
                    break;
                default:
                    System.out.println("Please select a valid option.");
                    break;
            }
        } catch(Exception ee){
            System.out.println("Please select a valid option!");
        }
    }
}


public void displayReportingScreen(){
    Scanner scanner = new Scanner(System.in);

    Reports reportings = new Reports();

    boolean reporting = true;
    while(reporting){
        System.out.println(" --- Reports Home --- ");
        System.out.println("Please select an option (1,2,3,4,5,0) to run a pre-defined report or run a custom search");
        System.out.println("1 - Month to Date");
        System.out.println("2 - Previous Month");
        System.out.println("3 - Year to Date");
        System.out.println("4 - Previous Year");
        System.out.println("5 - Search by Vendor");
        System.out.println("0 - Back to Report page");
        int userInput3 = scanner.nextInt();

        try {
            switch (userInput3) {
                case 1:
                    reportings.monthToDate(l.listAllItems());
                    break;
                case 2:
                    reportings.previousMonth(l.listAllItems());
                    break;
                case 3:
                    reportings.yearToDate(l.listAllItems());
                    break;
                case 4:
                    reportings.previousYear(l.listAllItems());
                    break;
                case 5:
                    System.out.println("What vendor would you like to look up?");
                    String selection = scanner.nextLine();

                    reportings.searchVendor(l.listAllItems(), selection);
                    break;
                case 0:
                    displayLedgerScreen();
                    break;
                default:
                    System.out.println("Please select a valid option.");
                    break;
            }

        } catch (Exception r){
            System.out.println("Please select a valid option.");
        }
    }

}
}
