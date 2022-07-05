package com.company;

public class Main {
    /*
Design a parking lot using object-oriented principles

Goals:

Your solution should be in Java.
Assumptions:

The parking lot can hold motorcycles, cars and vans.

The parking lot has motorcycle spots and car spots.

A motorcycle can park in a motorcycle spot OR a regular spot.

A car can park in a regular spot

A van can park, but it will take up 3 regular spots

These are just a few assumptions. Feel free to ask your interviewer about more assumptions as needed
Here are a few methods that you should be able to run:

Tell us how many spots are remaining
Tell us how many total spots are in the parking lot
Tell us when the parking lot is full
Tell us when the parking lot is empty
Tell us when certain spots are full e.g. when all motorcycle spots are taken
Tell us how many spots vans are taking up
*/

    public static void main(String[] args) {
        CarPark carPark = new CarPark( 5, 5);
        Commands carParkCommands = new Commands(new String[]{"Print Status","Park Motorcycle", "Park Car", "Park Van", "Quit" });
        boolean isActive = true;

        System.out.println("Welcome to the Car Park");

        while (isActive){
            carParkCommands.printCommands();
            int userInput = carParkCommands.getIntegerInput();
            boolean parkingStatus = false;
            Parkable toPark = null;

            switch (userInput){
                case 1 :
                    printStatus(carPark);
                    break;
                case 2 :
                    toPark = new Motorcycle();
                    parkingStatus = carPark.parkVehicle(toPark);
                    break;
                case 3 :
                    toPark = new Car();
                    parkingStatus = carPark.parkVehicle(toPark);
                    break;
                case 4 :
                    toPark = new Van();
                    parkingStatus = carPark.parkVehicle(toPark);
                    break;
                default:
                    isActive = false;
                    break;
            }

            if(!parkingStatus && toPark != null){
                printFail(toPark);
            } else if (parkingStatus){
               printSuccess(toPark);
            }
        }
    }

    private static void printSuccess(Parkable parked){
        System.out.println("Your " + parked.getType() + " with id " + parked.getId() + " has been parked");
    }

    private static void printFail(Parkable parked){
        System.out.println("Your " + parked.getType() + " with id " + parked.getId() + " has not been parked");
    }

    private static void printStatus(CarPark carPark) {
        System.out.println("-----");
        System.out.println("The total spaces are " + carPark.getTotalSpaces());
        System.out.println("Remaining motorcycle spaces : " + carPark.getFreeMotorcycleSpaceCount());
        System.out.println("Remaining regular spaces : " + carPark.getFreeRegularSpaceCount());
        System.out.println("Total motorcycle : " +  carPark.getMotorcycleCount());
        System.out.println("Total cars : " + carPark.getCarCount());
        System.out.println("Total vans : " + carPark.getVanCount());
        System.out.println("-----");
    }
}
