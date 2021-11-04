package com.company;

public class Main {
    /*
Design a parking lot using object-oriented principles

Goals:
- Your solution should be in Java - if you would like to use another language, please let the interviewer know.

Assumptions:
- The parking lot can hold motorcycles, cars and vans
- The parking lot has motorcycle spots, car spots and large spots
- A motorcycle can park in any spot
- A car can park in a single compact spot, or a regular spot
- A van can park, but it will take up 3 regular spots
- These are just a few assumptions. Feel free to ask your interviewer about more assumptions as needed

Here are a few methods that you should be able to run:
- Tell us how many spots are remaining - done
- Tell us how many total spots are in the parking lot - done
- Tell us when the parking lot is full - done
- Tell us when the parking lot is empty - done
- Tell us when certain spots are full e.g. when all motorcycle spots are taken - done
- Tell us how many spots vans are taking up
*/

    public static void main(String[] args) {
        CarPark carPark = new CarPark(2, 5, 5);
        System.out.println("The number of free spaces is " + carPark.getNumberOfFreeSpaces());
        System.out.println("The total spaces are " + carPark.getTotalSpaces());

        carPark.parkVehicle(new Car("c1"));
        carPark.parkVehicle(new Car("c2"));

        System.out.println("The number of free spaces is " + carPark.getNumberOfFreeSpaces());
        System.out.println("The number of free car spaces is " + carPark.getNumberOfFreeSpaces("car"));

        carPark.parkVehicle(new Van("v1"));
        carPark.parkVehicle(new Van("v2"));
        carPark.parkVehicle(new Van("v3"));
        carPark.parkVehicle(new Van("v4"));

        carPark.parkVehicle(new Motorcycle("m1"));
        carPark.parkVehicle(new Motorcycle("m2"));

        System.out.println(carPark.getOverview());

        System.out.println("The number of free spaces is " + carPark.getNumberOfFreeSpaces());

        carPark.parkVehicle(new Motorcycle("m3"));
        carPark.parkVehicle(new Car("c3"));
        carPark.parkVehicle(new Van("v5"));

        System.out.println(carPark.getParkedVehicles());

    }
}
