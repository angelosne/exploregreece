package com.example.exploregreece.features.tour;

import com.example.exploregreece.features.tourPackage.TourPackage;

import javax.persistence.ManyToOne;

public class TourResponse {
    private long id;
    private String title;
    private String shortDescription;
    private double price;
    private int hoursDuration;
    private TourPackage tourPackage;
    private double pricePerHour;
    private DurationType durationType;

    public TourResponse(long id, String title, String shortDescription, double price, int hoursDuration, TourPackage tourPackage, double pricePerHour, DurationType durationType) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.price = price;
        this.hoursDuration = hoursDuration;
        this.tourPackage = tourPackage;
        this.pricePerHour = pricePerHour;
        this.durationType = durationType;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getHoursDuration() {
        return hoursDuration;
    }

    public void setHoursDuration(int hoursDuration) {
        this.hoursDuration = hoursDuration;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public DurationType getDurationType() {
        return durationType;
    }

    public void setDurationType(DurationType durationType) {
        this.durationType = durationType;
    }
}
