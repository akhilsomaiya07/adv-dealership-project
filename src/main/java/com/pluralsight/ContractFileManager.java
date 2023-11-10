package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public void saveContract(Contract contract){

        String contractType = contract instanceof SalesContract ? "Sale" : "Lease";
        String date = contract.getDate();
        String customerName = contract.getCustomerName();
        String customerEmail = contract.getCustomerEmail();
        Vehicle vehicleSold = contract.getVehicleSold();
        int vin = vehicleSold.getVin();
        int year = vehicleSold.getYear();
        String make = vehicleSold.getMake();
        String model = vehicleSold.getModel();
        String vehicleType = vehicleSold.getVehicleType();
        String color = vehicleSold.getColor();
        int odometer = vehicleSold.getOdometer();
        double price = vehicleSold.getPrice();
        double monthlyPayment = contract.getMonthlyPayment();
        double totalCost = 0;
        double salesTaxAmount = 0;
        double recordingFee = 0;
        double processingFee = 0;
        boolean finance = false;
        double expectedEndingValue = 0;
        double leaseFee = 0;


        if (contractType.equalsIgnoreCase("Sale")){
            SalesContract salesCon = (SalesContract) contract;
            salesTaxAmount =  salesCon.getSalesTaxAmount();
            recordingFee = salesCon.getRecordingFee();
            processingFee = salesCon.getProcessingFee();
            finance = salesCon.isFinance();
            totalCost = salesCon.getTotalPrice();
        }
        if(contractType.equalsIgnoreCase("Lease")){
            LeaseContract leaseCon= (LeaseContract) contract;
            expectedEndingValue = leaseCon.getExpectedEndingValue();
            leaseFee = leaseCon.getLeaseFee();
            totalCost = leaseCon.getTotalPrice();
        }



        try( BufferedWriter bw = new BufferedWriter(new FileWriter("Contracts.csv",true))){
            if(contract instanceof SalesContract)

            {
                try{
                    bw.write(contractType.toUpperCase() + "|" + date + "|" + customerName + "|" + customerEmail + "|" + vin + "|" + year + "|" + make + "|" + model + "|" + vehicleType + "|" + color + "|" + odometer + "|" + price + "|" + salesTaxAmount + "|" + recordingFee + "|" + processingFee + "|" + totalCost + "|" + finance + "".toUpperCase() + "|" + monthlyPayment + "\n");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            if(contract instanceof LeaseContract)

            {
                try{
                    bw.write(contractType.toUpperCase() + "|" + date + "|" + customerName + "|" + customerEmail + "|" + vin + "|" + year + "|" + make + "|" + model + "|" + vehicleType + "|" + color + "|" + odometer + "|" + price + "|" + expectedEndingValue + "|" + leaseFee + "|" + totalCost + "|" + monthlyPayment+ "\n");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }catch(Exception e){
            System.out.println("Provide a valid contract, ONLY LEASE OR SALES CONTRACT ARE SUPPORTED");
        }
    }
}