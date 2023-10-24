package org.example;

import java.io.File;
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

    public void monthToDate(){
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
        } catch(Exception x){
            System.out.println("Unable to generate report. Let's Try again.");
        }

    }

    public void previousMonth(){
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
        } catch (Exception i){
            System.out.println("Unable to generate report. Let's Try again.");
        }

        System.out.println();

    }

    public void yearToDate(){
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

        } catch (Exception ex){
            System.out.println("Unable to generate report. Let's Try again.");
        }
    }

    public void previousYear(){
        LocalDate pyDate = LocalDate.of(2022,1,1);
        try{
            FileWriter pYear = new FileWriter("src/main/resources/previousYearReport.txt");
            pYear.write("date|time|description|vendor|amount" + "\n");

            for (Transactions py : transactions){
                if (!pyDate.equals(LocalDate.now())){
                    pYear.write(py.getDate() +"|"+ py.getTime() +"|"+ py.getDesc() +"|"+ py.getVendor() +"|"+ py.getAmount() + "\n");
                }
            }
        }catch(Exception y){
            System.out.println("Unable to generate report. Let's Try again.");
        }



    }

    //search by vendor
public void searchVendor(String vendor){
        ArrayList<Transactions> transactions = ShowAllItems();

        Transactions vendorID = null;
        for(Transactions v: transactions){
            if(v.getVendor().equalsIgnoreCase(vendor)){
                vendorID = v;
            }

        }
try{
    FileWriter search = new FileWriter("src/main/resources/byVendorReport");
    search.write("date|time|description|vendor|amount" + "\n");

    for(Transactions sv: transactions){

    }
} catch (Exception s){
    System.out.println("Unable to generate report. Let's try again.");
}
        //will need to use for loop to iterate through array
}
}
