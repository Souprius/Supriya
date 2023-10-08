package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide your deposit amount below.");
        double deposit = scanner.nextDouble();

        System.out.println("Please advise your current interest rate below.");
        double interestRate = scanner.nextDouble();

        System.out.println("Please provide your term in years below.");
        int termInYears = scanner.nextInt();

        int termInMonths;
        double convertedRate;
        double dailyCompounding;
        double totalInterest;

        termInMonths = termInYears * 12;
        convertedRate = interestRate / 100;
        dailyCompounding = interestRate / 365;

        totalInterest = deposit * convertedRate;
        double futureValue = deposit * Math.pow((1 + convertedRate / 365), 365 * termInYears);

        System.out.printf("Your CD's ending balance will be %.2f and you would have earned %.2f in interest.",futureValue,totalInterest);

        }
    }
