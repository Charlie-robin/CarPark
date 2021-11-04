package com.company;

public class Van extends Vehicle implements IVehicle{
    final private String type = "van";
    public Van( String id) {
        super(3, id);
    }

    public String getType() {
        return type;
    }

    @Override
    public String getId() {
        return type + "-" + super.getId();
    }
}
