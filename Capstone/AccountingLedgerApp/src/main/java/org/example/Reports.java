package org.example;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Reports {

    //month to date
    //previous month
    //year to date
    //previous year

    public void monthToDate(ArrayList<Transactions> transactions){
        LocalDate monthToDate = LocalDate.of(2023,10,1);
        try{
            FileWriter writeMonth = new FileWriter("src/main/resources/monthToDateReport.txt");
            writeMonth.write("date|time|description|vendor|amount" + "\n");

            for(Transactions mtd: transactions){
                if (!monthToDate.equals(LocalDate.now())){
                    writeMonth.write(mtd.getDate() + "|" + mtd.getTime() + "|" + mtd.getDesc() + "|" + mtd.getVendor()+ "|" + mtd.getAmount() + "\n");

                }
            }
            writeMonth.close();

            FileInputStream month = new FileInputStream("src/main/resources/monthToDateReport.txt");
            Scanner scanner = new Scanner(month);

            String input;
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                System.out.println(input);
            }
        } catch(Exception x){
            System.out.println("Unable to generate report. Let's Try again.");
        }

    }

    public void previousMonth(ArrayList<Transactions> transactions){
        LocalDate date = LocalDate.of(2023,9,1);
        try{
            FileWriter writePrevious = new FileWriter("src/main/resources/previousMonthReport.txt");
            writePrevious.write("date|time|description|vendor|amount" + "\n");

            for(Transactions pm : transactions){
                if(!date.equals(LocalDate.now())){
                    writePrevious.write(pm.getDate() + "|" + pm.getTime() +"|"+ pm.getDesc() +"|"+ pm.getVendor() +"|"+ pm.getAmount() + "\n");

                }
            }
            writePrevious.close();

            FileInputStream previous = new FileInputStream("src/main/resources/previousMonthReport.txt");
            Scanner scanner = new Scanner(previous);

            String input;
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                System.out.println(input);
            }

        } catch (Exception i){
            System.out.println("Unable to generate report. Let's Try again.");
        }

        System.out.println();

    }

    public void yearToDate(ArrayList<Transactions> transactions){
        LocalDate startDate = LocalDate.of(2023,1,1);
        try {
            FileWriter writeYear = new FileWriter("src/main/resources/yearToDateReport.txt");
            writeYear.write("date|time|description|vendor|amount" + "\n");

            for(Transactions report : transactions) { //check reports.toArray(new Transaction[0])
                if(!startDate.equals(LocalDate.of(2023,12,31))){
                    writeYear.write(report.getDate() + "|" + report.getTime() + "|" + report.getDesc() + "|" + report.getVendor() + "|" + report.getAmount() + "\n");

                }
            }
            writeYear.close();

            FileInputStream year = new FileInputStream("src/main/resources/yearToDateReport.txt");
            Scanner scanner = new Scanner(year);

            String input;
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                System.out.println(input);
            }

        } catch (Exception ex){
            System.out.println("Unable to generate report. Let's Try again.");
        }
    }

    public void previousYear(ArrayList<Transactions> transactions){
        LocalDate pyDate = LocalDate.of(2022,1,1);
        try{
            FileWriter pYear = new FileWriter("src/main/resources/previousYearReport.txt");
            pYear.write("date|time|description|vendor|amount" + "\n");

            for (Transactions py : transactions){
                if (!pyDate.equals(LocalDate.now())){
                    pYear.write(py.getDate() +"|"+ py.getTime() +"|"+ py.getDesc() +"|"+ py.getVendor() +"|"+ py.getAmount() + "\n");

                }
            }
            pYear.close();
            FileInputStream previous = new FileInputStream("src/main/resources/previousYearReport.txt");
            Scanner scanner = new Scanner(previous);

            String input;
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                System.out.println(input);

            }
        }catch(Exception y){
            System.out.println("Unable to generate report. Let's Try again.");
        }

    }

    //search by vendor
public void searchVendor(ArrayList<Transactions> transactions , String vendor){
        //ArrayList<Transactions> transactions = ShowAllItems();
//should iterate to search for vendor
   try{
         Transactions vendorID = null;
       FileWriter search = new FileWriter("src/main/resources/byVendorReport.txt");
       search.write("date|time|description|vendor|amount" + "\n");

        for(Transactions v: transactions){
            if(v.getVendor().equalsIgnoreCase(vendor)){
                vendorID = v;
                search.write(vendorID.getDate() + "|" + vendorID.getTime() + "|" + vendorID.getDesc() + "|" + vendorID.getVendor() + "|" + vendorID.getAmount() + "\n");

            }
        }
       search.close();

       //i want it to print out the specific vendor lines
       FileInputStream vendorPull = new FileInputStream("src/main/resources/byVendorReport.txt");
       Scanner scanner = new Scanner(vendorPull);

       String input;
       while(scanner.hasNextLine()){
           input = scanner.nextLine();
           System.out.println(input);
       }
   }    catch (Exception s){
            System.out.println("Unable to generate report. Let's try again.");
        }
        //will need to use for loop to iterate through array
}
}
