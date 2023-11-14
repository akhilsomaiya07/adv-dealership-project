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
        dealership = dealershipFileManager.getDealership();
    }
    private void updateDealership(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);
    }
    private void updateContract(Contract contract){
        ContractFileManager contractFileManager = new ContractFileManager();
        contractFileManager.saveContract(contract);
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

        displayHelper(dealership.getVehicleByPrice(min, max));
    }

    public void processGetByMakeModelRequest(){
        System.out.println("enter make:\uD83D\uDC49\uD83C\uDFFD");
        String make = input.next();
        System.out.println("enter model:\uD83D\uDC49\uD83C\uDFFD");
        String model = input.next();
        displayHelper(dealership.getVehicleByMakeModel(make, model));

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
        displayHelper(dealership.getVehicleByYear(min, max));

    }

    public void processGetByColorRequest(){
        System.out.println("enter color:\uD83D\uDC49\uD83C\uDFFD");
        String color = input.next();
        System.out.println(color);
        displayHelper(dealership.getVehicleByColor(color));
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
        displayHelper(dealership.getVehicleByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest(){
        System.out.println("enter vehicle type:\uD83D\uDC49\uD83C\uDFFD");
        String type = input.next();
        displayHelper(dealership.getVehicleByType(type));
    }

    public void processGetAllVehicleRequest(){
        displayHelper(dealership.getAllVehicle());
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
                year = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for year. Please enter a valid integer(s) ONLY.");
            }
        }

        while (make == null) {
            System.out.print("Enter make:\uD83D\uDC49\uD83C\uDFFD ");
            make = input.nextLine();
            if (make.contains("|")) {
                System.out.println("Make cannot contain a pipe character (|)");
                make = null;
            }
        }

        while (model == null) {
            System.out.print("Enter model: \uD83D\uDC49\uD83C\uDFFD");
            model = input.nextLine();
            if (model.contains("|")) {
                System.out.println("Model cannot contain a pipe character (|)");
                model = null;
            }
        }

        while (vehicleType == null) {
            System.out.print("Enter vehicle type:\uD83D\uDC49\uD83C\uDFFD ");
            vehicleType = input.nextLine();
            if (vehicleType.contains("|")) {
                System.out.println("Vehicle type cannot contain a pipe character (|)");
                vehicleType = null;
            }
        }

        while (color == null) {
            System.out.print("Enter color:\uD83D\uDC49\uD83C\uDFFD ");
            color = input.nextLine();
            if (color.contains("|")) {
                System.out.println("Color cannot contain a pipe character (|)");
                color = null;
            }
        }

        while (odometer == -1) {
            System.out.print("Enter odometer:\uD83D\uDC49\uD83C\uDFFD ");
            try {
                odometer = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for odometer. Please enter a valid integer(s) ONLY.");
            }
        }

        while (price == -1.0) {
            System.out.print("Enter price:\uD83D\uDC49\uD83C\uDFFD ");
            try {
                price = Double.parseDouble(input.nextLine());
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
        List<Vehicle> allVehicle = new ArrayList<>(dealership.getAllVehicle());
        for (Vehicle x: allVehicle){
            if (x.getVin()==vin){
                try{
                    dealership.removeVehicle(x);
                    System.out.println("vehicle is removed " + x);
                    updateDealership();
                    counter++;
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        }
        if (counter==0) {
            System.out.println("VIN not found! NO vehicle removed!");
        }

    }

    public void processBuyOrLeaseRequest(){
        System.out.println("Awesome! you like to BUY or LEASE a Vehicle!");


        try{
            System.out.println("Enter B to see buy options, OR L to see Lease options!:");
            String BorL = input.nextLine();
            while (!BorL.equalsIgnoreCase("B")||!BorL.equalsIgnoreCase("l")) {
                if (BorL.equalsIgnoreCase("b")) {
                    processGetAllVehicleRequest();
                    System.out.println("Enter the date of the contract:");
                    String date = input.nextLine();
                    System.out.println("Enter your name:");
                    String name = input.nextLine();
                    System.out.println("Enter your email address:");
                    String address = input.nextLine();
                    System.out.println("Would you like to Finance the vehicle? Enter 'Y' for yes OR 'N' for NO:");
                    boolean finance = input.nextLine().equalsIgnoreCase("Y");
                    System.out.println("Enter the vin of the vehicle you want to buy:");
                    int vin = Integer.parseInt(input.nextLine());
                    Vehicle vehicle = null;
                    for (Vehicle x : dealership.getAllVehicle()) {
                        if (x.getVin() == vin) {
                            vehicle = x;
                        }
                    }
                    dealership.removeVehicle(vehicle);
                    SalesContract salesContract = new SalesContract(date, name, address, vehicle, finance);
                    updateContract(salesContract);
                    updateDealership();
                    System.out.println("Congratulations!! you have successfully bought this Vehicle:" + vehicle);
                    break;
                } else if (BorL.equalsIgnoreCase("l")) {
                    processGetAllVehicleRequest();
                    System.out.println("Enter the date of the contract:");
                    String date = input.nextLine();
                    System.out.println("Enter your name:");
                    String name = input.nextLine();
                    System.out.println("Enter your email address:");
                    String address = input.nextLine();
                    System.out.println("Enter the vin of the vehicle you want to buy:");
                    int vin = Integer.parseInt(input.next());
                    Vehicle vehicle = null;
                    for (Vehicle x : dealership.getAllVehicle()) {
                        if (x.getVin() == vin) {
                            vehicle = x;

                        }
                    }
                    dealership.removeVehicle(vehicle);
                    LeaseContract salesContract = new LeaseContract(date, name, address, vehicle);
                    updateContract(salesContract);
                    updateDealership();
                    System.out.println("Congratulations!! you have successfully Leased this Vehicle:" + vehicle);
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("INVALID!! please enter 'B' to see buying options OR 'L' to see lease options");
            System.out.println(e);
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
            System.out.println("10) Buy or Lease a vehicle");
            System.out.println("99) Quit");


            System.out.print("Your Selection \uD83D\uDC49\uD83C\uDFFD");
            String input = scanner.nextLine().trim();


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
                case "10":
                    processBuyOrLeaseRequest();
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