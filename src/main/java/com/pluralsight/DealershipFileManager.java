package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    public Dealership loadDealership() {
        Dealership dealershipFromFile = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));

            String fileLine;
            List<Vehicle> vehicleList = new ArrayList<>();
            while ((fileLine = bufferedReader.readLine()) != null) {
                String[] tokens = fileLine.split("\\|");

                if(tokens.length == 3) {
                    dealershipFromFile = new Dealership(tokens[0], tokens[1], tokens[2]);
                    continue;
                }

                vehicleList.add(new Vehicle(
                        Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[1]),
                        tokens[2],
                        tokens[3],
                        tokens[4],
                        tokens[5],
                        Integer.parseInt(tokens[6]),
                        Double.parseDouble(tokens[7])
                ));
            }

            if (dealershipFromFile != null) {
                for (Vehicle vehicle : vehicleList) {
                    dealershipFromFile.addVehicle(vehicle);
                }
            }

            return dealershipFromFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDealership(Dealership dealership) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory.csv"));

            bufferedWriter.write(dealership.toString() + "\n");

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                bufferedWriter.write(vehicle.toString() + "\n");
            }

            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

