package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DealershipFileManager {


    public Dealership getDealership(){

        Dealership dealership = new Dealership("Souprius Autos","940 W Round Grove Rd", "867-5309");
        try{
            FileInputStream cars = new FileInputStream("src/main/resources/inventory.csv");
            Scanner scanner = new Scanner(cars);

            scanner.nextLine();

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] car = line.split("\\|");

                int vin = Integer.parseInt(car[0]);
                int year = Integer.parseInt(car[1]);
                String make = car[2];
                String model = car[3];
                String vehicleType = car[4];
                String color = car[5];
                int odometer = Integer.parseInt(car[6]);
                double price = Double.parseDouble(car[7]);

                Vehicle newVehicle = new Vehicle(vin, year,make,model,vehicleType,color,odometer,price);
                dealership.addVehicle(newVehicle);


            }
        } catch (FileNotFoundException ex){
            System.out.println("Could not find vehicle. Let's try again.");
        } catch (ArrayIndexOutOfBoundsException ee){
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership){
        try{
            FileWriter newCars = new FileWriter("src/main/resources/inventory.csv");
            for(Vehicle v: dealership.getAllVehicles()){
                newCars.write("VIN: " + v.getVin() + "|" + "Year: " + v.getYear() + "|" + "Make: " + v.getMake() +
                        "|" + "Model: " + v.getModel() + "|" + "Vehicle Type: " + v.getVehicleType()+ "|" + "Color: "
                        + v.getColor()+ "|" + "Odometer: " + v.getOdometer()+ "|" + "Price: " + v.getPrice() + "\n");

                newCars.close();
            }
        } catch(IOException ex){

        }

    }

}
