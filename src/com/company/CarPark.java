package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarPark {
    private final int totalSpaces;
    private final int regularSpaceLimit;
    private final int motorcycleSpaceLimit;
    private final List<Parkable> motorcycleSpaces = new ArrayList<>();
    private final List<Parkable> regularSpaces = new ArrayList<>();

    public CarPark(int carLimit, int motorcycleLimit) {
        this.regularSpaceLimit = carLimit;
        this.motorcycleSpaceLimit = motorcycleLimit;
        this.totalSpaces = carLimit + motorcycleLimit;
    }

    public int getTotalSpaces() {
        return totalSpaces;
    }

    public int getFreeRegularSpaceCount(){
        return regularSpaceLimit - regularSpaces.size();
    }

    public int getFreeMotorcycleSpaceCount(){
        return motorcycleSpaceLimit - motorcycleSpaces.size();
    }

    private List<Parkable> getSpaces(VehicleTypes vehicleType) {
        if (vehicleType == VehicleTypes.MOTORCYCLE) {
            return motorcycleSpaces;
        } else {
            return regularSpaces;
        }
    }

    private int getLimit(VehicleTypes vehicleType) {
        if (vehicleType == VehicleTypes.MOTORCYCLE) {
            return motorcycleSpaceLimit;
        } else {
            return regularSpaceLimit;
        }
    }

    private int getVehicleCount(VehicleTypes vehicleType, List<Parkable> spaces){
        return spaces.stream().reduce(0, (acc, cur) -> cur.getType() == vehicleType ? acc + 1 : acc, Integer::sum );
    }

    public int getMotorcycleCount() {
        return getVehicleCount(VehicleTypes.MOTORCYCLE, motorcycleSpaces) + getVehicleCount(VehicleTypes.MOTORCYCLE, regularSpaces);
    }

    public int getCarCount() {
        return getVehicleCount(VehicleTypes.CAR, regularSpaces);
    }

    public int getVanCount() {
        return getVehicleCount(VehicleTypes.VAN, regularSpaces) / VehicleTypes.VAN.getSize();
    }

    private int getNumberOfFreeSpaces(VehicleTypes vehicleType) {
        List<Parkable> spaces = getSpaces(vehicleType);
        return getLimit(vehicleType) - spaces.size();
    }

    private int getNumberOfFreeSpaces() {
        return totalSpaces - motorcycleSpaces.size() - regularSpaces.size();
    }

    public boolean parkVehicle(Parkable vehicle) {
        if (getNumberOfFreeSpaces() == 0) {
            return false;
        }

        VehicleTypes vehicleType = vehicle.getType();
        int freeSpaces = getNumberOfFreeSpaces(vehicleType);
        List<Parkable> spaces = getSpaces(vehicleType);

        if(vehicleType.canParkInAnySpace() && motorcycleSpaces.size() == motorcycleSpaceLimit){
            spaces = regularSpaces;
            freeSpaces = getNumberOfFreeSpaces();
        }

        if (freeSpaces >= vehicle.getSize()) {
            int counter = vehicle.getSize();
            while (counter != 0) {
                spaces.add(vehicle);
                counter--;
            }
            return true;
        }

       return false;
    }


}
