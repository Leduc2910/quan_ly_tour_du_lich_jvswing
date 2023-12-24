package model;

public class Tour_Vehicle {
    private int id;
    private int tour_id;
    private int vehicle_id;

    public Tour_Vehicle(int id, int tour_id, int vehicle_id) {
        this.id = id;
        this.tour_id = tour_id;
        this.vehicle_id = vehicle_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
}
