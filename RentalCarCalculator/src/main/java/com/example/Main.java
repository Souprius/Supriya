package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        double basicRental = 29.99;
        double tollFee = 3.95;
        double gpsFee = 2.95;
        double roadsideFee = 3.95;
        double youngRate = 1.3;
        double options = 0;

        System.out.println("Welcome to the rental car calculator!What day would you like to pick up the rental? (M-F)");
        String userDate = scanner.nextLine();

        System.out.println("How many days would you like to rent the vehicle?");
        int numberOfDays = scanner.nextInt();

        System.out.println("Would you like a toll tag for an additional fee of $3.95/day? (true/false)");
        boolean tollTag = scanner.nextBoolean();

        if(tollTag){
            options += tollFee;
        }
        System.out.println("Would you like GPS included for $2.95/day? (true/false)");
        boolean gps = scanner.nextBoolean();

        if(gps){
            options += gpsFee;
        }
        System.out.println("Would you like roadside assistance for $3.95/day? (true/false)");
        boolean roadsideAssistance = scanner.nextBoolean();

        if(roadsideAssistance){
            options += roadsideFee;
        }

        System.out.println("How old are you?");
        int userAge = scanner.nextInt();
        if (userAge <= 25) {
            System.out.println("The cost per day of the base rental due to your age is: $" + basicRental * youngRate);
        } else {
            System.out.println("Your base rental rate per day remains at $29.99.");
        }
        double totalCost = (basicRental + options) * numberOfDays;
        double
        System.out.println("Your basic rental cost is: $" + basicRental * numberOfDays);

        System.out.println("Your add-ons cost is: $" + options * numberOfDays);
        System.out.println("Your total rental charge is: $" + totalCost);
        }
        }







