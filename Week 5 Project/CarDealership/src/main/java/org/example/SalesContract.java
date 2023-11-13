package org.example;

public class SalesContract extends Contract {

    private double salesTax;
    private double recordingFee;
    private boolean financing;

    private double processingFee;

    public SalesContract(String date, String customerName,String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, double salesTax, double recordingFee, boolean financing, double processingFee) {
        super(date, customerName,customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.financing = financing;
        this.processingFee = processingFee;
    }

    public double getSalesTax() {
        return getVehicleSold().getPrice() * 0.05;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return 100;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public boolean isFinancing() {
        return financing;
    }

    public void setFinancing(boolean financing) {
        this.financing = financing;
    }

    public double getProcessingFee() {
        if(getVehicleSold().getPrice() > 10000){
            processingFee = 295;
        } else{
            processingFee = 495;
        }
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    @Override
    public double getTotalPrice(){
        double totalPrice = 0;
        double totalInterest = 0;
        if(!financing){
             totalPrice = this.getVehicleSold().getPrice() + getSalesTax() + getProcessingFee() + getRecordingFee();
        } else if(financing){
            if(this.getVehicleSold().getPrice() <= 10000){
            totalInterest = 0.0425 * this.getVehicleSold().getPrice() * 48;
            } else{
                 totalInterest = 0.0525 * this.getVehicleSold().getPrice() * 24;
            }
            totalPrice = this.getVehicleSold().getPrice() + getSalesTax() + getRecordingFee() + getProcessingFee() + totalInterest;
        }
       return totalPrice;
    }

    public double annualInterest(){
        double annualInterest = 0;
        if(this.getVehicleSold().getPrice() >= 10000){
            annualInterest = 0.0425;
        } else {annualInterest = 0.0525;
        }
        return annualInterest;
    }

    public int numberOfPayments(){
        int number = 0;
        if(this.getVehicleSold().getPrice() >= 10000){
            number = 48;
        } else{
            number = 24;
        }
        return number;
    }
    @Override
    public double getMonthlyPayment(){
        double monthlyPayment = 0;
        double p = getTotalPrice();
        double r = this.annualInterest() / 12;
        int n = this.numberOfPayments();

        //P×r / 1-(1+r)^−n

        Math.pow(p * r / 1-(1+r),-numberOfPayments());

        return monthlyPayment;
    }

}
