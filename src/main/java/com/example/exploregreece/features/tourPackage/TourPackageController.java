package com.example.exploregreece.features.tourPackage;

import com.example.exploregreece.features.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourPackageController {
    private TourPackageService service;

    public TourPackageController(TourPackageService service) {
        this.service = service;
    }

    @GetMapping(path = "tourPackages")
    public ResponseEntity getAllTourPackages() {
//        List<TourPackage> tourPackages = service.getAllTourPackages();
//        return tourPackages;
        return new ResponseEntity(service.getAllTourPackages(), HttpStatus.OK);
    }

    @PostMapping(path = "tourPackage")
    public ResponseEntity createTourPackage(@RequestBody TourPackageInput input) {
      return new ResponseEntity(service.createTourPackage(input), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "tourPackage/{id}")
    public ResponseEntity deleteTourPackageById(@PathVariable long id){
        return new ResponseEntity(service.deleteTourPackageById(id), HttpStatus.OK);
    }

    @PutMapping(path = "tourPackage/{id}")
    public ResponseEntity updateTourPackage(@RequestBody TourPackageInput input,
                                            @PathVariable long id){
        try {
            return new ResponseEntity(service.updateTourPackage(input, id), HttpStatus.OK);
        } catch (TourPackageNotFoundException e) {
            CustomError error = new CustomError(0, "Wrong input", "Tour Package does not exist");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        }

    }



}
