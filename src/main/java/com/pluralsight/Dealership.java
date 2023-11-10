package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) || vehicle.getModel().equalsIgnoreCase(model)) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }


}