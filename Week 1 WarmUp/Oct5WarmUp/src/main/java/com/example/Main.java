package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("How's the weather today? (Please enter Sunny, Cloudy or Rainy) ");
        String weatherOption = scanner.nextLine();

        if(weatherOption.equals("Sunny")){
            System.out.println("It's a great day for outdoor activities!");
        }
        else if(weatherOption.equals("Cloudy")){
            System.out.println("The weather is a bit uncertain.");
        }
        else if(weatherOption.equals("Rainy")){
            System.out.println("Don't forget your umbrella!");
        }
        else{
            System.out.println("Sorry, I'm not sure about that weather type.");
        }
    }
}
