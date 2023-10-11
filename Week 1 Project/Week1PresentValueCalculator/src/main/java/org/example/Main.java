package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide your expected monthly payout below.");
        double monthlyPayout = scanner.nextDouble();

        System.out.println("Please provide your expected interest rate below.");
        double annualInterestRate = scanner.nextDouble();

        System.out.println("Please advise how many years you are expecting pay out below.");
        int termInYears = scanner.nextInt();

        int monthlyPayments = termInYears * 12;
        double monthlyInterestRate = annualInterestRate / 12 / 100;

        double presentValue;
        presentValue = monthlyPayout * Math.pow(1 - (1 - monthlyInterestRate), -monthlyPayments) / monthlyInterestRate;

        System.out.printf("To fund an annuity that pays $%.2f for %d years and earns an expected %.2f interest, you would need to invest $%.2f.",
                monthlyPayout,
                termInYears,
                annualInterestRate,
                presentValue);



        }
    }
