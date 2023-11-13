package org.example;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName,String customerEmail, Vehicle vehicleSold, double expectedEndingValue, double leaseFee, double totalPrice, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return this.getVehicleSold().getPrice() * 0.5;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return this.getVehicleSold().getPrice() * 0.07;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice(){
        double totalPrice = 0;

        totalPrice = this.getVehicleSold().getPrice() + getLeaseFee() + (getMonthlyPayment() * 36);
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment(){
        double monthlyPayment = 0;
        double P = this.getVehicleSold().getPrice();
        double RV = getExpectedEndingValue();
        double r = 0.04 / 12;
        int n = 36;

        //(P−RV)×r / 1−(1+r)^−n
        monthlyPayment = Math.pow((P-RV)*r / 1-(1+r),-n);
        return monthlyPayment;
    }
}
