package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//The only thing I'll say here is that there might need to be more checks on
//protecting yourself from the user putting in bad data. You're just sort of
//assuming they'll give you data in the form you expect.
public class UserInterface {

    Dealership dealership = new Dealership("Souprius Autos","940 W Round Grove Rd", "867-5309");
    Scanner scanner = new Scanner(System.in);
    //
    private void init(){
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();
    }

    public void display(){
        init();

        System.out.println("* * * * Welcome * * * *");

        System.out.println("Please select an option from the below list.");
        System.out.println("==========================================");
        System.out.println("You can search by: ");
        System.out.println("==========================================");
        System.out.println("1 - Price range");
        System.out.println("2 - Make/Model");
        System.out.println("3 - Year range");
        System.out.println("4 - Color");
        System.out.println("5 - Mileage range");
        System.out.println("6 - Type (sedan, truck, SUV, minivan)");
        System.out.println("==========================================");
        System.out.println("Additional Options:");
        System.out.println("7 - List All");
        System.out.println("8 - Add vehicle");
        System.out.println("9 - Remove Vehicle");
        System.out.println("99 - Quit");
        int answer = scanner.nextInt();

        scanner.nextLine();

        boolean loggedIn = true;

        while(loggedIn){

            switch(answer){

                case 1:
                    processGetByPriceRequest();
                case 2:
                    processGetByMakeModelRequest();
                case 3:
                    processGetByYearRequest();
                case 4:
                    processGetByColorRequest();
                case 5:
                    processGetByMileageRequest();
                case 6:
                    processGetByVehicleTypeRequest();
                case 7:
                    processGetByAllVehiclesRequest();
                case 8:
                    processAddVehicleRequest();
                case 9:
                    processRemoveVehicleRequest();
                case 99:
                    System.out.println("See you later!");
                    System.exit(0);

                    loggedIn = false;
                default:
                    System.out.println("Please select a valid option.");
            }
        }

    }

    private void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle v: vehicles){
            System.out.printf("VIN: %d  | Year: %d  | Make: %s  | Model:%s  | Vehicle Type: %s  | Color: %s  | Odometer: %d  | Price: %.2f  \n",
                    v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
        }

    }

    public void processGetByPriceRequest(){
        System.out.println("What is the min price? ");
        int min = scanner.nextInt();

        System.out.println("What is the max price? ");
        int max = scanner.nextInt();

        scanner.nextLine();//consume line
        dealership.getVehiclesByPrice(min, max);
    }

    public void processGetByMakeModelRequest(){
        System.out.println("What is the make?");
        String make = scanner.nextLine();

        System.out.println("What is the model?");
        String model = scanner.nextLine();

        dealership.getVehicleByMake(make,model);
    }

   public void processGetByYearRequest(){
       System.out.println("Please provide the year range you're looking for.");
       System.out.println("Min: ");
       int yearMin = scanner.nextInt();

       scanner.nextLine();//consume

       System.out.println("Max: ");
       int yearMax = scanner.nextInt();

       scanner.nextLine();//consume

       dealership.getVehiclesByYear(yearMin, yearMax);
    }

    public void processGetByColorRequest(){
        System.out.println("What color vehicle are you looking for?");
        String color = scanner.nextLine();

        dealership.getVehiclesByColor(color);
    }

    public void processGetByMileageRequest(){
        System.out.println("Please provide the odometer range you're looking for.");
        System.out.println("Min: ");
        int odometerMin = scanner.nextInt();

        System.out.println("Max: ");
        int odometerMax = scanner.nextInt();

        scanner.nextLine();//consume

        dealership.getVehiclesByMileage(odometerMin,odometerMax);
    }

    public void processGetByVehicleTypeRequest(){
        System.out.println("What is the vehicle type you're looking for?");
        String vehicleType = scanner.nextLine();

        dealership.getVehiclesByType(vehicleType);
    }

    public void processGetByAllVehiclesRequest(){
        dealership.getAllVehicles();
    }

    public void processAddVehicleRequest(){
        System.out.println("What is the VIN?");
        int vin = scanner.nextInt();

        System.out.println("What is the year?");
        int year = scanner.nextInt();

        System.out.println("What is the make?");
        String make = scanner.nextLine();

        System.out.println("What is the model?");
        String model = scanner.nextLine();

        System.out.println("What is the vehicle type? (sedan, truck, SUV, minivan)");
        String type = scanner.nextLine();

        System.out.println("What is the vehicle color?");
        String color = scanner.nextLine();

        System.out.println("Please list the odometer reading below. ");
        int odom = scanner.nextInt();

        System.out.println("What is the price of this vehicle?");
        double price = scanner.nextDouble();

        scanner.nextLine(); //consume

        Vehicle addCar = new Vehicle(vin, year, make,model,type,color,odom,price);
        dealership.addVehicle(addCar);
        System.out.println("This vehicle has been added. Thank you.");
    }

    public void processRemoveVehicleRequest(){
        System.out.println("What is the VIN?");
        int rVin = scanner.nextInt();

        System.out.println("What is the year?");
        int rYear = scanner.nextInt();

        System.out.println("What is the make?");
        String rMake = scanner.nextLine();

        System.out.println("What is the model?");
        String rModel = scanner.nextLine();

        System.out.println("What is the vehicle type? (sedan, truck, SUV, minivan)");
        String rType = scanner.nextLine();

        System.out.println("What is the vehicle color?");
        String rColor = scanner.nextLine();

        System.out.println("Please list the odometer reading below. ");
        int rOdom = scanner.nextInt();

        System.out.println("What is the price of this vehicle?");
        double rPrice = scanner.nextDouble();

        scanner.nextLine();//consume

        Vehicle removeV = new Vehicle(rVin,rYear,rMake,rModel,rType,rColor,rOdom,rPrice);
        dealership.removeVehicle(removeV);

        System.out.println("This vehicle has been removed. Thank you.");
    }
}
