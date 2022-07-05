package com.company;

import java.util.UUID;

public abstract class Vehicle implements Parkable {
    private final VehicleTypes type;
    private final String id = UUID.randomUUID().toString();

    public Vehicle(VehicleTypes type) {
        this.type = type;
    }

    public VehicleTypes getType() {
        return type;
    }

    public boolean canParkInAnySpace(){return type.canParkInAnySpace();}

    public int getSize() { return type.getSize(); }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return type.toString() + id.substring(0, 5);
    }
}
