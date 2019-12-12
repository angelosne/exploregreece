package com.example.exploregreece.features.tourPackage;

import com.example.exploregreece.features.tour.Tour;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TourPackageService {
    private TourPackageRepository repository;
    private TourPackageInputToEntity tourPackageInputToEntity;
    private TourPackageEntityToResponse tourPackageEntityToResponse;

    public TourPackageService(TourPackageRepository repository, TourPackageInputToEntity tourPackageInputToEntity, TourPackageEntityToResponse tourPackageEntityToResponse) {
        this.repository = repository;
        this.tourPackageInputToEntity = tourPackageInputToEntity;
        this.tourPackageEntityToResponse = tourPackageEntityToResponse;
    }

    public List<TourPackageResponse> getAllTourPackages() {
        List<TourPackageResponse> tourPackagesToReturn = new ArrayList<>();
        Iterable<TourPackage> retrievedTourPackages = repository.findAll();
        for (TourPackage tourPackage: retrievedTourPackages) {
            tourPackagesToReturn.add(tourPackageEntityToResponse.apply(tourPackage));
        }
        return tourPackagesToReturn;
    }


    public TourPackageResponse createTourPackage(TourPackageInput tourPackageInput) {
        TourPackage tourPackageToSave = tourPackageInputToEntity.apply(tourPackageInput);
        TourPackage savedTourPackage = repository.save(tourPackageToSave);
        TourPackageResponse tourPackageResponse = tourPackageEntityToResponse.apply(savedTourPackage);
        return tourPackageResponse;
    }

    public TourPackageResponse deleteTourPackageById(long id){
        Optional<TourPackage> tourPackageToDelete = repository.findById(id);
        repository.deleteById(id);
        return tourPackageEntityToResponse.apply(tourPackageToDelete.get());
    }

    public TourPackageResponse updateTourPackage(TourPackageInput input, long id) throws TourPackageNotFoundException {
        Optional<TourPackage> retrievedTourPackageOptional = repository.findById(id);
        if (retrievedTourPackageOptional.isEmpty()){
            throw new TourPackageNotFoundException();
        }
        else {
            TourPackage TourPackageToUpdate = retrievedTourPackageOptional.get();
            if (input.getDescription()!=null) {
                TourPackageToUpdate.setDescription(input.getDescription());
            }
            if (input.getDestination()!=null){
                TourPackageToUpdate.setDestination(input.getDestination());
            }
            if (input.getDuration()!=null){
                TourPackageToUpdate.setDuration(input.getDuration());
            }
            if (input.getPrice()!=null){
                TourPackageToUpdate.setPrice(input.getPrice());
            }
            if (input.getTitle()!=null){
                TourPackageToUpdate.setTitle(input.getTitle());
            }

            TourPackage tourPackageToSave = repository.save(TourPackageToUpdate);
            return tourPackageEntityToResponse.apply(tourPackageToSave);
        }

    }







}
