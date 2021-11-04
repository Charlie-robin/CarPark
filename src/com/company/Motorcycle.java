package com.company;

public class Motorcycle extends Vehicle implements IVehicle{
    private final String type = "motorcycle";
    public Motorcycle( String id) {
        super(1, id);
    }


    public String getType() {
        return type;
    }

    @Override
    public String getId() {
        return type + "-" + super.getId();
    }
}
