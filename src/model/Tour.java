package model;

public class Tour {
    private int id;
    private String tour_name;
    private String tour_time;
    private String start_point;
    private String destination;
    private double price;
    private String schedule;
    private String description;
    private String image;
    private Tour_category tourCategory;

    public Tour(String tour_name, String tour_time, String start_point, String destination, double price, String schedule, String description, String image, Tour_category tourCategory) {
        this.tour_name = tour_name;
        this.tour_time = tour_time;
        this.start_point = start_point;
        this.destination = destination;
        this.price = price;
        this.schedule = schedule;
        this.description = description;
        this.image = image;
        this.tourCategory = tourCategory;
    }

    public Tour(int id, String tour_name, String tour_time, String start_point, String destination, double price, String schedule, String description, String image, Tour_category tourCategory) {
        this.id = id;
        this.tour_name = tour_name;
        this.tour_time = tour_time;
        this.start_point = start_point;
        this.destination = destination;
        this.price = price;
        this.schedule = schedule;
        this.description = description;
        this.image = image;
        this.tourCategory = tourCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTour_name() {
        return tour_name;
    }

    public void setTour_name(String tour_name) {
        this.tour_name = tour_name;
    }

    public String getTour_time() {
        return tour_time;
    }

    public void setTour_time(String tour_time) {
        this.tour_time = tour_time;
    }

    public String getStart_point() {
        return start_point;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Tour_category getTourCategory() {
        return tourCategory;
    }

    public void setTourCategory(Tour_category tourCategory) {
        this.tourCategory = tourCategory;
    }
}
