package org.example;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

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
        System.out.println("10 - Buy Vehicle");
        System.out.println("11 - Lease Vehicle");
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
                case 10:
                    processBuyVehicle();
                case 11:
                    processLeaseVehicle();
                case 99:
                    System.out.println("See you later!");
                    System.exit(0);

                    loggedIn = false;
                default:
                    System.out.println("Please select a valid option.");
            }
        }

    }

    private void displayVehicles(List<Vehicle> vehicles){
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
        List<Vehicle> printPrice = dealership.getVehiclesByPrice(min, max);
        displayVehicles(printPrice);
    }

    public void processGetByMakeModelRequest(){
        System.out.println("What is the make?");
        String make = scanner.nextLine();

        System.out.println("What is the model?");
        String model = scanner.nextLine();

        List<Vehicle> printModel = dealership.getVehicleByMake(make,model);
        displayVehicles(printModel);
    }

   public void processGetByYearRequest(){
       System.out.println("Please provide the year range you're looking for.");
       System.out.println("Min: ");
       int yearMin = scanner.nextInt();

       scanner.nextLine();//consume

       System.out.println("Max: ");
       int yearMax = scanner.nextInt();

       scanner.nextLine();//consume

       List<Vehicle> printYear = dealership.getVehiclesByYear(yearMin, yearMax);
       displayVehicles(printYear);
    }

    public void processGetByColorRequest(){
        System.out.println("What color vehicle are you looking for?");
        String color = scanner.nextLine();

        List<Vehicle> printColor = dealership.getVehiclesByColor(color);
        displayVehicles(printColor);
    }

    public void processGetByMileageRequest(){
        System.out.println("Please provide the odometer range you're looking for.");
        System.out.println("Min: ");
        int odometerMin = scanner.nextInt();

        System.out.println("Max: ");
        int odometerMax = scanner.nextInt();

        scanner.nextLine();//consume

        List<Vehicle> printMileage =  dealership.getVehiclesByMileage(odometerMin,odometerMax);
        displayVehicles(printMileage);
    }

    public void processGetByVehicleTypeRequest(){
        System.out.println("What is the vehicle type you're looking for?");
        String vehicleType = scanner.nextLine();

        List<Vehicle> printType = dealership.getVehiclesByType(vehicleType);
        displayVehicles(printType);
    }

    public void processGetByAllVehiclesRequest(){
        List<Vehicle> printAll = dealership.getAllVehicles();
        displayVehicles(printAll);
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

    DealershipFileManager fm = new DealershipFileManager();

    public void processBuyVehicle(){
        System.out.println("What is you name?");
        String name = scanner.nextLine();

        System.out.println("What is your email address?");
        String email = scanner.nextLine();

        System.out.println("What is the vehicle VIN you would like to purchase?");
        int VIN = scanner.nextInt();

        Vehicle option = null;
        //use vin and search through vehicle array/inventory
        for(Vehicle vehicle: dealership.getAllVehicles()){
            if(VIN == vehicle.getVin()){
                option = vehicle;
            }
        }

        System.out.printf("Is %s the vehicle you would like to purchase? True/False",option);
        boolean readyToPurchase = scanner.nextBoolean();

        //need to use vehicle OPTION to get the total price & monthly payment
        //will I need to instantiate another contract?
        if (readyToPurchase){
            //instantiate sales contract
            SalesContract sc = null;
            String date = String.valueOf(LocalDate.now());

           double totalPrice = sc.getTotalPrice();
           double monthlyPayment = sc.getMonthlyPayment();
           double processing = sc.getProcessingFee();
           double salesTax = sc.getSalesTax();
           double recordingFee = sc.getRecordingFee();

           boolean financing = sc.isFinancing();

           if (financing){
               sc = new SalesContract(date,name,email,option,totalPrice,monthlyPayment,salesTax,recordingFee,true,processing);
               ContractFileManager.saveContract(sc);
           } else {
               sc = new SalesContract(date,name,email,option,totalPrice,monthlyPayment,salesTax,recordingFee,false,processing);
               ContractFileManager.saveContract(sc);
           }

            System.out.printf("For vehicle %s, the total payment is $%.2f and the monthly payment is $%.2f.", option,totalPrice,monthlyPayment);
        }
    }

    public void processLeaseVehicle(){
        System.out.println("What is your name?");
        String name = scanner.nextLine();

        System.out.println("What is your email address?");
        String email = scanner.nextLine();

        System.out.println("What is the VIN of the vehicle you would like to lease?");
        int VIN = scanner.nextInt();

        Vehicle selection = null;
        for(Vehicle vehicle: dealership.getAllVehicles()){
            if(VIN == vehicle.getVin()){
                selection = vehicle;
            }
        }

        System.out.printf("Is %s the vehicle you would like to purchase? True/False",selection);
        boolean isLeasing = scanner.nextBoolean();

        if(isLeasing){
            LeaseContract lc = null;

            String date = String.valueOf(LocalDate.now());
            double expectedValue = lc.getExpectedEndingValue();
            double leaseFee = lc.getLeaseFee();
            double totalPrice = lc.getTotalPrice();
            double monthlyPayment = lc.getMonthlyPayment();

            lc = new LeaseContract(date,name,email,selection,expectedValue,leaseFee,totalPrice,monthlyPayment);
            ContractFileManager.saveContract(lc);
        }
    }
}
