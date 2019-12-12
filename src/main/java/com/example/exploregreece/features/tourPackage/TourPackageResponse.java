package com.example.exploregreece.features.tourPackage;



public class TourPackageResponse {

    private long id;
    private String title;
    private String description;
    private double price;
    private int duration;
    private Destination destination;
    private double pricePerDuration;

    public TourPackageResponse(long id,
                               String title,
                               String description,
                               double price,
                               int duration,
                               Destination destination,
                               double pricePerDay) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.destination = destination;
        this.pricePerDuration = pricePerDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public double getPricePerDuration() {
        return pricePerDuration;
    }

    public void setPricePerDuration(double pricePerDuration) {
        this.pricePerDuration = pricePerDuration;
    }
}
