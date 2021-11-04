package com.company;

public class Vehicle {
    private boolean isParked = false;
    private int size;
    private int parkedX;
    private int parkedY;
    private String id;

    public Vehicle(int size, String id) {
        this.size = size;
        this.id = id;
    }

    public void park(int x, int y){
        isParked = true;
        parkedX = x;
        parkedY = y;
    }


    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean parked) {
        isParked = parked;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getParkedX() {
        return parkedX;
    }

    public void setParkedX(int parkedX) {
        this.parkedX = parkedX;
    }

    public int getParkedY() {
        return parkedY;
    }

    public void setParkedY(int parkedY) {
        this.parkedY = parkedY;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
