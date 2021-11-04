package com.company;

public class Car extends Vehicle implements IVehicle{
    private final String type = "car";

    public Car( String id) {
        super(2, id);
    }

    public String getType() {
        return type;
    }

    @Override
    public String getId() {
        return type + "-" + super.getId();
    }
}
