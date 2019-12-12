package com.example.exploregreece.features.tourPackage;

import java.util.function.Function;

public class TourPackageEntityToResponse implements Function<TourPackage, TourPackageResponse> {
    @Override
    public TourPackageResponse apply(TourPackage tourPackage) {
        return new TourPackageResponse(
                tourPackage.getId(),
                tourPackage.getTitle(),
                tourPackage.getDescription(),
                tourPackage.getPrice(),
                tourPackage.getDuration(),
                tourPackage.getDestination(),
                mapPricePerDay(tourPackage)

        );
    }

    private double mapPricePerDay(TourPackage tourPackage) {
        return tourPackage.getPrice()/tourPackage.getDuration();
    }
}
