package com.pluralsight;

import java.io.*;

public class DealershipFileManager {


    public Dealership getDealership(){
        Dealership dealership = new Dealership("","","");

        int lineCounter = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader( "inventory.csv"))){

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                if(lineCounter<=1){
                    dealership.setName(tokens[0]);
                    dealership.setAddress(tokens[1]);
                    dealership.setPhone(tokens[2]);
                }else {
                    int vin = Integer.parseInt(tokens[0]);
                    int year = Integer.parseInt(tokens[1]);
                    String make = tokens[2];
                    String model = tokens[3];
                    String vehicleType = tokens[4];
                    String color = tokens[5];
                    int odometer = Integer.parseInt(tokens[6]);
                    double price = Double.parseDouble(tokens[7]);

                    Vehicle vehicle = new Vehicle(vin,year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);

                }

                lineCounter++;
            }

        } catch (IOException e) {
            System.err.print(e);
        }

        return dealership;
    };

    public void saveDealership(Dealership dealership){
        String dealershipName= String.format("%1s|%1s|%1s", dealership.getName(),dealership.getAddress(),dealership.getPhone());
        try{
            BufferedWriter nameWriter = new BufferedWriter(new FileWriter("inventory.csv"));
            nameWriter.write(dealershipName+"\n");
            nameWriter.close();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv",true));
                for(Vehicle x:dealership.getAllVehicle()){
                    String vehicleFormat = x.getVin()+"|"+x.getYear()+"|"+x.getMake()+"|"+x.getModel()+"|"+x.getVehicleType()+"|"+x.getColor()+"|"+x.getOdometer()+"|"+x.getPrice()+"\n";
                    writer.write(vehicleFormat);
                }
                writer.close();
            }catch (IOException e){
                System.out.println(e);
            }

        }
        catch(IOException e){
            System.out.println(e);
        }
    };
}