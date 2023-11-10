package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
    //__________________________________________
    public Dealership(String name, String address, String phone) {
        this.inventory = new ArrayList<Vehicle>();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
//__________________________________________

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

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }
    //_______________
    public List<Vehicle> getVehicleByPrice(double min,double max){
        List<Vehicle> filteredArray = new ArrayList<Vehicle>();

        for(Vehicle x:inventory){
            if (x.getPrice()>=min && x.getPrice()<=max){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }
    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        List<Vehicle> filteredArray = new ArrayList<>();

        for(Vehicle x:inventory){
            if (x.getMake().equalsIgnoreCase(make) || x.getModel().equalsIgnoreCase(model)){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }
    public List<Vehicle> getVehicleByYear(int min,int max){
        List<Vehicle> filteredArray = new ArrayList<>();

        for(Vehicle x:inventory){
            if (x.getYear()>=min && x.getYear()<=max){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }
    public List<Vehicle> getVehicleByColor(String color){
        List<Vehicle> filteredArray = new ArrayList<>();

        for(Vehicle x:inventory){
            if (x.getColor().equalsIgnoreCase(color) ){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }
    public List<Vehicle> getVehicleByMileage(int min, int max){
        List<Vehicle> filteredArray = new ArrayList<>();

        for(Vehicle x:inventory){
            if (x.getOdometer()>=min && x.getOdometer()<=max){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }

    public List<Vehicle> getVehicleByType(String type){
        List<Vehicle> filteredArray = new ArrayList<>();

        for(Vehicle x:inventory){
            if (x.getVehicleType().equalsIgnoreCase(type) ){
                filteredArray.add(x);
            }
        }
        return filteredArray;
    }
    public List<Vehicle> getAllVehicle(){
        return this.inventory;
    }
    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        this.inventory.remove(vehicle);
    }
}