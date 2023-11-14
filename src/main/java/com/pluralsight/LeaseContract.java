package com.pluralsight;

public class LeaseContract extends Contract {
    private double leaseFee;
    private double expectedEndingValue ;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.leaseFee  = .07*this.getVehicleSold().getPrice();
        this.expectedEndingValue= this.getVehicleSold().getPrice()/2;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }


    //monthly payment with a given interest rate can be calculated using the formula: //M = P * (J / (1 - (Math.pow(1/(1 + J), N))));
    //where each letter represents the following:
    //M = monthly payment
    //P = principal (price of the car)
    //J = monthly interest rate (annual interest rate divided by 12)
    //N = number of months of payments
    //for example, if you have a 4 year (48 month) loan at 4.25% annual interest rate, your monthly payment would be calculated like this:
    //M = 35000 * (.0425/12) / (1 - Math.pow(1/(1 + (.0425/12)), 48))

    @Override
    public double getMonthlyPayment() {
        return this.getTotalPrice() * (.04/12) / (1 - Math.pow(1/(1 + (.04/12)), 36));
    }
    @Override
    public double getTotalPrice() {
        return (this.getVehicleSold().getPrice() - expectedEndingValue) + this.getLeaseFee();
    }



}