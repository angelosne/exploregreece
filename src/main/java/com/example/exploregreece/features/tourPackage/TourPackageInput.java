package com.example.exploregreece.features.tourPackage;


public class TourPackageInput {
    private String title;
    private String description;
    private double price;
    private int duration;
    private Destination destination;

    public TourPackageInput() {
    }

    public TourPackageInput( String title, String description, double price, int duration, Destination destination) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.destination = destination;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getDuration() {
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
}
