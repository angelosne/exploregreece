package com.example.exploregreece.features.tour;


import com.example.exploregreece.features.CustomError;
import com.example.exploregreece.features.tourPackage.TourPackage;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TourController {

    private TourService service;

    public TourController(TourService service) {
        this.service = service;
    }

    @GetMapping(path = "all-tours")
    public ResponseEntity getAllTours() {
        return new ResponseEntity(service.getAllTours(),
                HttpStatus.OK);
    }

    @GetMapping(path = "tours-by-price/{price}")
    public ResponseEntity getTourByPrice(@PathVariable("price")double price) {
        if (price < 10)
            return new ResponseEntity(
                    new CustomError(1,
                            "Price to low",
                            "Minimum price should be at least 10"),
                    HttpStatus.BAD_REQUEST
            );
        else if (price > 100000)
            return new ResponseEntity(
                    new CustomError(2,
                            "Price to high",
                            "Maximum price should be at max 100000"),
                    HttpStatus.BAD_REQUEST
            );
        else
            return new ResponseEntity(service.getTourByPrice(price),
                    HttpStatus.OK);


    }

    @GetMapping(path = "tour-by-id/{id}")
    public String getTourById(@PathVariable("id") long id) {
        return service.getTourById(id);
    }

    @GetMapping("tours-between/{pricemin}/{pricemax}")
    public List<TourResponse> getTourBetweenPrice(@PathVariable double pricemin,
                                                  @PathVariable double pricemax) {
        return service.getTourBetweenPrice(pricemin,pricemax);
    }



}
