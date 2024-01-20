package com.usecase.flightmanagement.repository;

import com.usecase.flightmanagement.entities.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Flight,Long> {
    List<Flight> findAll();
}
