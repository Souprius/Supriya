package org.example;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ContractFileManager {

    public static Contract readSalesContract() {
        Contract contract = null;
        // vehicle sold? 43210|2018|Jeep|Wrangler|SUV|Green|26785|24995.00
        try{
            FileInputStream sales = new FileInputStream("src/main/resources/contract.txt");
            Scanner scanner = new Scanner(sales);

            //SALE| contractType
            // 20210928| date
            // Dana Wyatt| customerName
            // dana@texas.com| customerEmail
            // 10112| VIN
            // 1993| year
            // Ford| make
            // Explorer| model
            // SUV| type
            // Red| color
            // 525123| odometer
            // 995.00| price <-- orig vehicle price
            // 49.75| salesTax
            // 100.00| recordingFee
            // 295.00| processingFee
            // 1439.75| totalPrice
            // NO| financing
            // 0.00 monthlyPayment

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] sold = line.split("\\|");

                //will put type in from when printing e.g. sout "SALE"
                String date = sold[0];
                String customerName = sold[1];
                String customerEmail = sold[2];


                int vin = Integer.parseInt(sold[3]);
                int year = Integer.parseInt(sold[4]);
                String make = sold[5];
                String model = sold[6];
                String vehicleType = sold[7];
                String color = sold[8];
                int odometer = Integer.parseInt(sold[9]);
                double price = Double.parseDouble(sold[10]);

                Vehicle vehicleSold = new Vehicle(vin, year,make,model,vehicleType,color,odometer,price);

                double salesTax = Double.parseDouble(sold[11]);
                double recordingFee = Double.parseDouble(sold[12]);
                double processingFee = Double.parseDouble(sold[13]);
                double totalPrice = Double.parseDouble(sold[14]);
                boolean financing = Boolean.parseBoolean(sold[15]);
                double monthlyPayment = Double.parseDouble(sold[16]);

                contract = new SalesContract(date, customerName,customerEmail,vehicleSold, salesTax,recordingFee,processingFee,totalPrice,financing,monthlyPayment);

            }

        } catch (IOException ex){

        }
        return contract;
    }

    public static Contract readLeaseContract(){
        Contract contract2 = null;
        try{
            FileInputStream leasing = new FileInputStream("src/main/resources/contract.txt");
            Scanner scanner = new Scanner(leasing);

            //LEASE|
            // 20210928|
            // Zachary Westly|
            // zach@texas.com|
            // 37846|
            // 2021|
            // Chevrolet|
            // Silverado|
            // truck|
            // Black|
            // 2750| odometer
            // 31995.00| price
            // 15997.50| expected value
            // 2239.65| lease fee
            // 18337.15| total price
            // 541.39 monthly payment

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] leased = line.split("\\|");

                String date = leased[0];
                String customerName = leased[1];
                String customerEmail = leased[2];

                int vin = Integer.parseInt(leased[3]);
                int year = Integer.parseInt(leased[4]);
                String make = leased[5];
                String model = leased[6];
                String vehicleType = leased[7];
                String color = leased[8];
                int odometer = Integer.parseInt(leased[9]);
                double price = Double.parseDouble(leased[10]);

                Vehicle vehicleSold = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);

                double expectedValue = Double.parseDouble(leased[11]);
                double leaseFee = Double.parseDouble(leased[12]);
                double totalPrice = Double.parseDouble(leased[13]);
                double monthlyPayment = Double.parseDouble(leased[14]);

                contract2 = new LeaseContract(date,customerName,customerEmail,vehicleSold,expectedValue,leaseFee,totalPrice,monthlyPayment);
            }
        }catch(IOException io){
        }

        return contract2;
    }
    public static void saveContract(Contract contract){
        try{
            FileWriter save = new FileWriter("src/main/resources/contract.txt",true);

            String header = String.format("%s| %s | %s |",contract.getDate(), contract.getCustomerName(),contract.getCustomerEmail());
            save.write(header);

            if(contract instanceof  SalesContract){
                String body = String.format("%d | %d | %s | %s | %s | %s | %d | %.2f | %.2f | %.2f | %.2f | %b |  %.2f ",
                        contract.getVehicleSold().getVin(),
                        contract.getVehicleSold().getYear(),
                        contract.getVehicleSold().getMake(),
                        contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getVehicleType(),
                        contract.getVehicleSold().getColor(),
                        contract.getVehicleSold().getOdometer(),
                        contract.getVehicleSold().getPrice(),
                        ((SalesContract) contract).getSalesTax(),
                        ((SalesContract) contract).getRecordingFee(),
                        ((SalesContract) contract).getProcessingFee(),
                        contract.getTotalPrice(),
                        ((SalesContract) contract).isFinancing(),
                        contract.getMonthlyPayment());

                save.write(body);
                save.close();
            } else if(contract instanceof LeaseContract){
                String body2 = String.format(" %d | %d | %s | %s | %s | %s | %d | %.2f | %.2f | %.2f | %.2f | %.2f",
                        contract.getVehicleSold().getVin(),
                        contract.getVehicleSold().getYear(),
                        contract.getVehicleSold().getMake(),
                        contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getVehicleType(),
                        contract.getVehicleSold().getColor(),
                        contract.getVehicleSold().getOdometer(),
                        contract.getVehicleSold().getPrice(),
                        ((LeaseContract) contract).getExpectedEndingValue(),
                        ((LeaseContract) contract).getLeaseFee(),
                        contract.getTotalPrice(),
                        contract.getMonthlyPayment());

                save.write(body2);
                save.close();
            }

        } catch(IOException ioe){
        }
    }

}
