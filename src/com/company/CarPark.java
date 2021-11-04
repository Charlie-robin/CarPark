package com.company;


import java.util.ArrayList;
import java.util.HashMap;

public class CarPark {
    private final int totalSpaces;
    private final int vanLimit;
    private final int carLimit;
    private final int motorcycleLimit;
    private final String[] vehicleTypes = {"motorcycle", "car", "van"};
    private final ArrayList<String> carSpaces = new ArrayList<String>();
    private final ArrayList<String> motorcycleSpaces = new ArrayList<String>();
    private final ArrayList<String> vanSpaces = new ArrayList<String>();
    private final ArrayList<IVehicle> parkedVehicles = new ArrayList<IVehicle>();
    private final HashMap<String, ArrayList<String>> overview = new HashMap<>();


    public CarPark(int vanLimit, int carLimit, int motorcycleLimit) {
        this.vanLimit = vanLimit;
        this.carLimit = carLimit;
        this.motorcycleLimit = motorcycleLimit;
        this.totalSpaces = vanLimit + carLimit + motorcycleLimit;
        overview.put("motorcycle", motorcycleSpaces);
        overview.put("car", carSpaces);
        overview.put("van", vanSpaces);
    }

    public int getTotalSpaces() {
        return totalSpaces;
    }

    public HashMap<String, ArrayList<String>> getOverview() {
        return overview;
    }

    public ArrayList<IVehicle> getParkedVehicles() {
        return parkedVehicles;
    }
// HELPERS
    private ArrayList<String> getSpaces(String vehicleType) {
        if (vehicleType.equals("motorcycle")) {
            return motorcycleSpaces;
        } else if (vehicleType.equals("car")) {
            return carSpaces;
        }
        return vanSpaces;
    }

    private int getLimit(String vehicleType) {
        if (vehicleType.equals("motorcycle")) {
            return motorcycleLimit;
        } else if (vehicleType.equals("car")) {
            return carLimit;
        }
        return vanLimit;
    }

    public int getNumberOfFreeSpaces(String vehicleType) {
        ArrayList<String> spaces = getSpaces(vehicleType);
        return getLimit(vehicleType) - spaces.size();
    }

    public int getNumberOfFreeSpaces() {
        int freeSpaces = 0;
        for (String vehicleType : vehicleTypes) {
            freeSpaces += getNumberOfFreeSpaces(vehicleType);
        }
        return freeSpaces;
    }


    public void parkVehicle(IVehicle vehicle) {
        if (getNumberOfFreeSpaces() == 0) {
            System.out.println("Car Park is full");
            return;
        }

        if (getNumberOfFreeSpaces(vehicle.getType()) > 0) {
            ArrayList<String> spaces = getSpaces(vehicle.getType());
            spaces.add(vehicle.getId());
            parkedVehicles.add(vehicle);
            System.out.println("Your Vehicle with id " + vehicle.getId() + " has been parked");
            return;
        }

        for (String vehicleType : vehicleTypes) {
            int freeSpaces = getNumberOfFreeSpaces(vehicleType);
            if (freeSpaces >= vehicle.getSize()) {
                ArrayList<String> spaces = getSpaces(vehicleType);
                int counter = vehicle.getSize();
                while (counter != 0) {
                    spaces.add(vehicle.getId());
                    counter--;
                }
                parkedVehicles.add(vehicle);
                System.out.println("Your Vehicle with id " + vehicle.getId() + " has been parked");
                return;
            }
        }
        System.out.println("Your Vehicle with id " + vehicle.getId() + " has not been parked");
    }


}
