package com.example.exploregreece.features.tour;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends CrudRepository<Tour,Long> {

    @Query("SELECT t.title FROM Tour t where t.id = :id")
    String findNameById(@Param("id")Long id);

    @Query("SELECT t FROM Tour t WHERE t.price <= :price")
    List<Tour> findTourByPrice(@Param("price")double price);

    @Override
    Iterable<Tour> findAll();
}
