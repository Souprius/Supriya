package org.example;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Supriya Federal Credit Union");

        boolean banking = true;
        while(banking){
            homeOptions();
        }


    }
    Scanner scanner = new Scanner(System.in);
public void addDepositPrompt(){
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
}

public void makeAPaymentPrompt(){
    System.out.println("What is the date of transaction? Format: YYYY-MM-DD");
    String date = scanner.nextLine();

    System.out.println("What is the time of the transaction? Format: HH:MM:SS");
    String time = scanner.nextLine();

    System.out.println("What is a short description of the transaction?");
    String desc = scanner.nextLine();

    System.out.println("Who is the vendor?");
    String vendor = scanner.nextLine();

    System.out.println("What was the amount?");
    double amount = scanner.nextDouble();
}



}