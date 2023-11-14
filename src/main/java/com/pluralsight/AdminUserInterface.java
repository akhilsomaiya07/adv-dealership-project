package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminUserInterface {

    ArrayList<Contract> contractList;
    public AdminUserInterface() {
    }
    UserInterface ui = new UserInterface();
    public void display(){
        getContract();
        displayMenu();
    }

    public void processGetAllContracts(){
        displayHelper(contractList);
    }
    private void getContract(){
        ContractFileManager contractFileManager = new ContractFileManager();
        contractList=contractFileManager.loadContract();
    }
    private void displayHelper(ArrayList<Contract> listToBeDisplayed){
        for (Contract contract: listToBeDisplayed){
            System.out.println(contract.toString());
        }
    }



    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("As an Admin you can Choose an option from the following:");
            System.out.println("1) Get all Contracts");
            System.out.println("99) back to main menu");


            System.out.print("Your Selection \uD83D\uDC49\uD83C\uDFFD");
            String input = scanner.nextLine().trim();


            switch (input) {
                case "1":
                    processGetAllContracts();
                    break;
                case "99":
                    ui.display();
                    running=false;

                    break;
            }
        }
    }
}