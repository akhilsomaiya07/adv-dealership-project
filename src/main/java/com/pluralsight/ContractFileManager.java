package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {


    public ArrayList<Contract> loadContract() {
        ArrayList<Contract> contractList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Contracts.csv"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                if (tokens[0].equalsIgnoreCase("Sales")) {
                    String date = tokens[1];
                    String customerName = tokens[2];
                    String customerEmail = tokens[3];
                    int vin = Integer.parseInt(tokens[4]);
                    int year = Integer.parseInt(tokens[5]);
                    String make = tokens[6];
                    String model = tokens[7];
                    String vehicleType = tokens[8];
                    String color = tokens[9];
                    int odometer = Integer.parseInt(tokens[10]);
                    double price = Double.parseDouble(tokens[11]);
                    double salesTaxAmount = Double.parseDouble(tokens[12]);
                    double recordingFee = Double.parseDouble(tokens[13]);
                    double processingFee = Double.parseDouble(tokens[14]);
                    double totalCost = Double.parseDouble(tokens[15]);
                    boolean finance = Boolean.parseBoolean(tokens[16]);
                    double monthlyPayment = Double.parseDouble(tokens[17]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    SalesContract salesContract = new SalesContract(date, customerName, customerEmail, vehicle, finance);
                    contractList.add(salesContract);
                } else if (tokens[0].equalsIgnoreCase("Lease")) {
                    String date = tokens[1];
                    String customerName = tokens[2];
                    String customerEmail = tokens[3];
                    int vin = Integer.parseInt(tokens[4]);
                    int year = Integer.parseInt(tokens[5]);
                    String make = tokens[6];
                    String model = tokens[7];
                    String vehicleType = tokens[8];
                    String color = tokens[9];
                    int odometer = Integer.parseInt(tokens[10]);
                    double price = Double.parseDouble(tokens[11]);
                    double expectedEndingValue = Double.parseDouble(tokens[12]);
                    double leaseFee = Double.parseDouble(tokens[13]);
                    double totalCost = Double.parseDouble(tokens[14]);
                    double monthlyPayment = Double.parseDouble(tokens[15]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    LeaseContract leaseContract = new LeaseContract(date, customerName, customerEmail, vehicle);
                    contractList.add(leaseContract);
                } else {
                    System.out.println("Invalid Contract Type");
                }

            }

        } catch (IOException e) {
            System.err.print(e);
        }
        return contractList;
    }

    public void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Contracts.csv", true))) {
            if (contract instanceof SalesContract) {
                try {
                    bw.write(contract.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (contract instanceof LeaseContract) {
                try {
                    bw.write(contract.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (Exception e) {
            System.out.println("Provide a valid contract, ONLY LEASE OR SALES CONTRACT ARE SUPPORTED");
        }
    }
}
