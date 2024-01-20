package com.usecase.flightmanagement.service;

import com.usecase.flightmanagement.constants.FlightStatus;
import com.usecase.flightmanagement.converter.FlightConverter;
import com.usecase.flightmanagement.model.Flight;
import com.usecase.flightmanagement.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<Flight> getAllFlights() {
        log.info("Getting list of flights from the inventory");
        return inventoryRepository.findAll().stream()
                .map(FlightConverter::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public void cancelFlight(Long id) {
        Optional<com.usecase.flightmanagement.entities.Flight> flight = inventoryRepository.findById(id);
        if (flight.isPresent()) {
            flight.get().setStatus(FlightStatus.CANCELLED.name());
            inventoryRepository.save(flight.get());
        }
    }

    public void addNewFlight(Flight flight) {
        com.usecase.flightmanagement.entities.Flight f = FlightConverter.convertDtoToEntity(flight);
        inventoryRepository.save(f);
    }

}
