package model;

public class Vehicle {
    private int id;
    private String vehicle_name;

    public Vehicle(int id) {
        this.id = id;
    }

    public Vehicle(int id, String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }
}
