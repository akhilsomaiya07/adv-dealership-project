package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    Scanner input = new Scanner(System.in);


    public UserInterface() {
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }


    private void init(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.loadDealership();
    }
    private void updateDealership(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);
    }


    public void display(){
        init();
        displayMenu();
    }

    public void processGetByPriceRequest(){
        Double min = null;
        Double max = null;

        while (min == null || max == null || min >= max) {
            System.out.print("Enter min:\uD83D\uDC49\uD83C\uDFFD ");
            String minInput = input.next();

            System.out.print("Enter max: \uD83D\uDC49\uD83C\uDFFD");
            String maxInput = input.next();

            try {
                min = Double.parseDouble(minInput);
                max = Double.parseDouble(maxInput);

                if (min >= max) {
                    System.out.println("Min price should be less than max price.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        }

        displayHelper(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByMakeModelRequest(){
        System.out.println("enter make:\uD83D\uDC49\uD83C\uDFFD");
        String make = input.next();
        System.out.println("enter model:\uD83D\uDC49\uD83C\uDFFD");
        String model = input.next();
        displayHelper(dealership.getVehiclesByMakeModel(make, model));

    }

    public void processGetByYearRequest(){
        int min = -1;
        int max = -1;

        while (min == -1 || max == -1 || min >= max) {
            System.out.print("Enter min:\uD83D\uDC49\uD83C\uDFFD ");
            String minInput = input.next();

            System.out.print("Enter max: \uD83D\uDC49\uD83C\uDFFD");
            String maxInput = input.next();

            try {
                min = Integer.parseInt(minInput);
                max = Integer.parseInt(maxInput);

                if (min >= max) {
                    System.out.println("Min price should be less than max price.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        }
        displayHelper(dealership.getVehiclesByYear(min, max));

    }

    public void processGetByColorRequest(){
        System.out.println("enter color:\uD83D\uDC49\uD83C\uDFFD");
        String color = input.next();
        System.out.println(color);
        displayHelper(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest(){
        int min = -1;
        int max = -1;

        while (min == -1 || max == -1 || min >= max) {
            System.out.print("Enter min:\uD83D\uDC49\uD83C\uDFFD ");
            String minInput = input.next();

            System.out.print("Enter max: \uD83D\uDC49\uD83C\uDFFD");
            String maxInput = input.next();

            try {
                min = Integer.parseInt(minInput);
                max = Integer.parseInt(maxInput);

                if (min >= max) {
                    System.out.println("Min price should be less than max price.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        }
        displayHelper(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest(){
        System.out.println("enter vehicle type:\uD83D\uDC49\uD83C\uDFFD");
        String type = input.next();
        displayHelper(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehicleRequest(){
        displayHelper(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(){
        int vin = -1;
        int year = -1;
        String make = null;
        String model = null;
        String vehicleType = null;
        String color = null;
        int odometer = -1;
        Double price = -1.0;
        while (vin == -1) {
            System.out.print("Enter vin:\uD83D\uDC49\uD83C\uDFFD ");
            try {
                vin = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for VIN. Please enter a valid integer(s) ONLY.");
            }
        }
        while (year == -1) {
            System.out.print("Enter year: \uD83D\uDC49\uD83C\uDFFD");
            try {
                year = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for year. Please enter a valid integer(s) ONLY.");
            }
        }

        while (make == null) {
            System.out.print("Enter make:\uD83D\uDC49\uD83C\uDFFD ");
            make = input.next();
            if (make.contains("|")) {
                System.out.println("Make cannot contain a pipe character (|)");
                make = null;
            }
        }

        while (model == null) {
            System.out.print("Enter model: \uD83D\uDC49\uD83C\uDFFD");
            model = input.next();
            if (model.contains("|")) {
                System.out.println("Model cannot contain a pipe character (|)");
                model = null;
            }
        }

        while (vehicleType == null) {
            System.out.print("Enter vehicle type:\uD83D\uDC49\uD83C\uDFFD ");
            vehicleType = input.next();
            if (vehicleType.contains("|")) {
                System.out.println("Vehicle type cannot contain a pipe character (|)");
                vehicleType = null;
            }
        }

        while (color == null) {
            System.out.print("Enter color:\uD83D\uDC49\uD83C\uDFFD ");
            color = input.next();
            if (color.contains("|")) {
                System.out.println("Color cannot contain a pipe character (|)");
                color = null;
            }
        }

        while (odometer == -1) {
            System.out.print("Enter odometer:\uD83D\uDC49\uD83C\uDFFD ");
            try {
                odometer = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for odometer. Please enter a valid integer(s) ONLY.");
            }
        }

        while (price == -1.0) {
            System.out.print("Enter price:\uD83D\uDC49\uD83C\uDFFD ");
            try {
                price = Double.parseDouble(input.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for price. Please enter a valid number ONLY");
            }
        }

        Vehicle vehicle = new Vehicle(vin,year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
        System.out.println("vehicle is added " + vehicle);
        updateDealership();
    }

    public void processRemoveVehicleRequest(){
        System.out.println("enter the vin of the vehicle you want to remove:\uD83D\uDC49\uD83C\uDFFD ");
        int vin = Integer.parseInt(input.next());
        int counter = 0;
        for (Vehicle x: dealership.getAllVehicles()){
            if (x.getVin()==vin){
                dealership.removeVehicle(x);
                System.out.println("vehicle is removed " + x);
                counter++;
            }
        }
        if (counter==0) {
            System.out.println("VIN not found! NO vehicle removed!");
        }else{
            updateDealership();
        }

    }

    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1) Find Vehicle within a price range");
            System.out.println("2) Find Vehicle by make or model");
            System.out.println("3) Find vehicle by year range");
            System.out.println("4) Find vehicle by color");
            System.out.println("5) Find vehicle by mileage range");
            System.out.println("6) Find vehicle by vehicle type (car,truck,suv,van)");
            System.out.println("7) List all vehicles");
            System.out.println("8) Add a vehicle");
            System.out.println("9) Remove a vehicle");
            System.out.println("99) Quit");


            System.out.print("Your Selection \uD83D\uDC49\uD83C\uDFFD");
            String input = scanner.next().trim();

            switch (input) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehicleRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;

                case "99":

                    running=false;
                    break;
            }
        }
    }
    private void displayHelper(List<Vehicle> listToBeDisplayed){
        for (Vehicle vehicle: listToBeDisplayed){
            System.out.println(vehicle);
        }
    }

}