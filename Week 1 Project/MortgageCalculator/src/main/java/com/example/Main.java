package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, welcome to our mortgage calculator.");
        System.out.println("Please enter your principal amount below.");
        double loanAmount = scanner.nextDouble();
        // p

        System.out.println("Please enter your loan term (in years). Whole numbers only.");
        int loanLength = scanner.nextInt();

        System.out.println("Please enter your current interest rate");
        double interestRate = scanner.nextDouble();

        double monthlyInterestRate = interestRate / 12;
        //r
        double finalInterest = monthlyInterestRate / 100;
        //(annual interest rate divided by 12 and then divided by 100 to convert to a decimal)

        //n
        int numberOfPayments = loanLength * 12;
        //(loan length in years multiplied by 12)


        double numerator = loanAmount * finalInterest * Math.pow(1 + finalInterest, numberOfPayments);
        double denominator = Math.pow((1 + finalInterest),numberOfPayments - 1);

        //m
        double monthlyPayment = numerator / denominator;

        double totalInterest = (monthlyPayment * numberOfPayments) - loanAmount;

        System.out.println("Your monthly payment is:$" + monthlyPayment);
        System.out.println("And the total interest is: $" + totalInterest);
    }


}