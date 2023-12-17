package com.dealership.demo.models;

import java.util.ArrayList;

public class Dealership {

    private int DealershipID;
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(int DealershipId, String name, String address, String phone) {
        this.DealershipID = DealershipId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public int getDealershipID() {
        return DealershipID;
    }

    public void setDealershipID(int dealershipID) {
        DealershipID = dealershipID;
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
}
