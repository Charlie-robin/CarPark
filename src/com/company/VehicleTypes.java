package com.company;

public enum VehicleTypes {

    MOTORCYCLE(1, true),
    CAR(1),
    VAN(3);

    private final boolean canParkInAnySpace;
    private final int size;

     VehicleTypes(int size, boolean canParkInAnySpace ){
        this.size = size;
        this.canParkInAnySpace = canParkInAnySpace;
    }

    VehicleTypes(int size ){
        this(size, false);
    }

    public boolean canParkInAnySpace() {
        return canParkInAnySpace;
    }

    public int getSize() {
        return size;
    }
}
