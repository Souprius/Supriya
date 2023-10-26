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

       UserInterface ui = new UserInterface();
       ui.homeOptions();

    }
}