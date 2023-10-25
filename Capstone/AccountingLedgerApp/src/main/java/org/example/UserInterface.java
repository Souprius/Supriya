package org.example;

import java.util.Scanner;


public class UserInterface {

public void homeOptions(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Please select an option (D,P,L,X) from the list below.");
    System.out.println("D - Add Deposit");
    System.out.println("P - Make a Payment");
    System.out.println("L - Open Ledger");
    System.out.println("X - Exit");
    String userInput = scanner.nextLine();

    boolean banking = true;
    while(banking){
        try{
            scanner.nextLine();
            switch(userInput){
                case "D":
                    Ledger.addDeposit();
                    break;
                case "P":
                    Ledger.makeAPayment();
                    break;
                case "L":
                    displayLedgerScreen();
                    break;
                case "X":
                    System.out.println("Thank you for using our app!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }

        }catch(Exception ex){
            System.out.println("Please select a valid option.");
        }
    }
}

public void displayLedgerScreen(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("--- Ledger Home ---");
    System.out.println("Please select an option (A,D, P,R, H) from the list below.");
    System.out.println("A - Show All");
    System.out.println("D - Show Deposits");
    System.out.println("P - Show Payments");
    System.out.println("R - Reporting");
    System.out.println("H - Home");
    String userInput2 = scanner.nextLine();

    boolean viewingLedger = true;
    while(viewingLedger){
        try{
            switch(userInput2){
                case "A":
                    showAllItems();
                    break;
                case "D":
                    showDeposit();
                    break;
                case "P":
                    showPayments();
                    break;
                case "R":
                    displayReportingScreen();
                    break;
                case "H":
                    homeOptions();
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        } catch(Exception ee){
            System.out.println("Please select a valid option.");
        }
    }
}


public void displayReportingScreen(){
    Scanner scanner = new Scanner(System.in);

    System.out.println("--- Reports Home ---");
    System.out.println("Please select an option (1,2,3,4,5,0) to run a pre-defined report or run a custom search");
    System.out.println("1 - Month to Date");
    System.out.println("2 - Previous Month");
    System.out.println("3 - Year to Date");
    System.out.println("4 - Previous Year");
    System.out.println("5 - Search by Vendor");
    System.out.println("0 - Back to Report page");
    int userInput3 = scanner.nextInt();

    boolean reporting = true;
    while(reporting){
        try {
            switch (userInput3) {
                case 1:
                    monthToDate();
                    break;
                case 2:
                    previousMonth();
                    break;
                case 3:
                    yearToDate();
                    break;
                case 4:
                    previousYear();
                    break;
                case 5:
                    break;
                case 0:
                    displayLedgerScreen();
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }

        } catch (Exception r){
            System.out.println("Please select a valid option.");
        }
    }

}
}
