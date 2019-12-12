package com.example.exploregreece.features.tourPackage;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TourPackageInputToEntity implements Function<TourPackageInput, TourPackage>
{
    @Override
    public TourPackage apply(TourPackageInput tourPackageInput) {
        return new TourPackage(tourPackageInput.getTitle(),
                tourPackageInput.getDescription(),
                tourPackageInput.getPrice(),
                tourPackageInput.getDuration(),
                tourPackageInput.getDestination()
        );
    }
}
