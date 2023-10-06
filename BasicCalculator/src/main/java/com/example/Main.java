package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me the first number:");
        double firstNumber = scanner.nextDouble();

        System.out.println("Give me the second number:");
        double secondNumber = scanner.nextDouble();

        System.out.println("What would you like to do? (A)dd, (M)ultiply, (D)ivide, (S)subract");
        String option = scanner.nextLine();

        String joinNumbers = scanner.nextLine();

        if (joinNumbers.equalsIgnoreCase("M")){
            System.out.println(firstNumber * secondNumber);
        }
        else if (joinNumbers.equalsIgnoreCase("A")){
            System.out.println(firstNumber + secondNumber);
        }
        else if (joinNumbers.equalsIgnoreCase("D")){
            System.out.println(firstNumber / secondNumber);
        }
        else if (joinNumbers.equalsIgnoreCase("S")){
            System.out.println(firstNumber - secondNumber);
        }
        else{
            System.out.println("Sorry, that is not a valid option!");
        }

    }
    }
