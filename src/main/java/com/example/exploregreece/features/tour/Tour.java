package com.example.exploregreece.features.tour;

import com.example.exploregreece.features.tourPackage.TourPackage;

import javax.persistence.*;

@Entity
public class Tour {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String shortDescription;
    private double price;
    private int hoursDuration;

    @ManyToOne
    private TourPackage tourPackage;

    public Tour() {
    }


    public Tour(String title, String shortDescription, double price, int hoursDuration, TourPackage tourPackage) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.price = price;
        this.hoursDuration = hoursDuration;
        this.tourPackage = tourPackage;
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
}
