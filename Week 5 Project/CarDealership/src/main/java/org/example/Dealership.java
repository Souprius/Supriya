package org.example;

import java.util.ArrayList;
import java.util.List;


public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList <Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    DealershipFileManager fm = new DealershipFileManager();

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> searchPrice = new ArrayList<>();
        for(Vehicle v: this.inventory){
            if(v.getPrice() >= min && v.getPrice() <= max){
                searchPrice.add(v);
            }
        }
        return searchPrice;
    }

    public List<Vehicle> getVehicleByMake(String make, String model){
        List<Vehicle> searchMake = new ArrayList<>();
        for(Vehicle v: this.inventory){
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                searchMake.add(v);
            }
        }

        return searchMake;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> searchYear = new ArrayList<>();
        for(Vehicle v: this.inventory){
            if(v.getYear() >= min && v.getYear() <= max){
                searchYear.add(v);
            }
        }

        return searchYear;
    }
    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> searchColor = new ArrayList<>();
        for(Vehicle v: this.inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                searchColor.add(v);
            }
        }
        return searchColor;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> searchMileage = new ArrayList<>();
        for(Vehicle v: this.inventory){
            if(v.getOdometer() >= min && v.getOdometer() <= max){
                searchMileage.add(v);
            }
        }
        return searchMileage;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> searchType = new ArrayList<>();
        for(Vehicle v: this.inventory ){
            if(v.getVehicleType().equalsIgnoreCase(vehicleType)){
                searchType.add(v);
            }
        }
        return searchType;
    }

    //not sure if this is working correctly will need to test
    public List<Vehicle> getAllVehicles(){
         return this.inventory;
    }

    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        this.inventory.remove(vehicle);

    }
}
