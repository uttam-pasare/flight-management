package com.usecase.flightmanagement.service;

import com.usecase.flightmanagement.model.Flight;
import com.usecase.flightmanagement.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    public List<Flight> getFlights(){
        log.info("Getting list of flights from the inventory");

        return inventoryRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private Flight convertToDto(com.usecase.flightmanagement.entities.Flight flight){
        return Flight.builder().id(flight.getId())
                .name(flight.getName())
                .route(flight.getRoute())
                .departure(flight.getDeparture())
                .build();
    }
}
