package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Please enter your numerical score below.");
        int numbericalScore = scanner.nextInt();

        scanner.close();

        if( numbericalScore >= 90){
            System.out.println("A");
        }
        else if(numbericalScore == 89){
            System.out.println("B");
        }
        else if(numbericalScore >=79){
            System.out.println("C");
        }
        else if(numbericalScore >=69){
            System.out.println("D");
        } else{
            System.out.println("F");
        }

        }
        }

