package com.example.exploregreece.features.tour;

import com.example.exploregreece.features.tourPackage.TourPackage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TourService {
    private TourRepository repository;

    public TourService(TourRepository repository) {
        this.repository = repository;
    }

    public List<TourResponse> getAllTours() {
        List<TourResponse> toursToReturn = new ArrayList<>();
        Iterable<Tour> retrievedTours = repository.findAll();
        for (Tour tour : retrievedTours) {
            toursToReturn.add(mapToTourResponse(tour));
        }
        return toursToReturn;
    }

    public List<TourResponse> getTourByPrice(double price) {
        List<TourResponse> toursToReturn = new ArrayList<>();
        List<Tour>  retrievedTours= repository.findTourByPrice(price);
        for (Tour tour: retrievedTours){
        toursToReturn.add(mapToTourResponse(tour));
        }
        return toursToReturn;
    }

    public List<TourResponse> getTourBetweenPrice(double pricemin,
                                                  double pricemax) {
        List<TourResponse> toursToReturn = new ArrayList<>();
        Iterable<Tour> retrievedTours = repository.findAll();
        for (Tour tour : retrievedTours) {
            if (tour.getPrice() >=  pricemin  && tour.getPrice() <= pricemax) {
                toursToReturn.add(mapToTourResponse(tour));
            }
        }
        return toursToReturn;
    }

    //    public List<Tour> getTourByPrice(double price) {
    //        List<Tour> toursToReturn = new ArrayList<>();
    //        Iterable<Tour> retrievedTours = repository.findAll();
    //        for (Tour tour: retrievedTours) {
    //            if (tour.getPrice() <= price){
    //                toursToReturn.add(tour);
    //            }
    //        }
    //        return toursToReturn;

    public String getTourById(long id) {

        return repository.findNameById(id);
    }

    private TourResponse mapToTourResponse(Tour tour) {
        return new TourResponse(
                tour.getId(),
                tour.getTitle(),
                tour.getShortDescription(),
                tour.getPrice(),
                tour.getHoursDuration(),
                tour.getTourPackage(),
                mapToPricePerHour(tour),
                mapDurationType(tour)
        );
    }

    private double mapToPricePerHour(Tour tour) {
        return tour.getPrice() / tour.getHoursDuration();
    }

    private DurationType mapDurationType(Tour tour) {
        if (tour.getHoursDuration() <= 4) {
            return DurationType.HALF_DAY;
        } else if (tour.getHoursDuration() <= 8) {
            return DurationType.FULL_DAY;
        } else
            return DurationType.EXTENDED;
    }
}

