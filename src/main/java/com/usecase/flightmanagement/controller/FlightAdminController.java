package com.usecase.flightmanagement.controller;

import com.usecase.flightmanagement.model.Flight;
import com.usecase.flightmanagement.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.usecase.flightmanagement.constants.ApiConstants.*;

@RestController
@RequestMapping(FLIGHT_MAPPING)
@RequiredArgsConstructor
public class FlightAdminController {

    private final InventoryService inventoryService;
    @PostMapping(value = ADD_FLIGHT)
    public ResponseEntity<HttpStatus> createFlight(@RequestBody Flight flight){
        inventoryService.addNewFlight(flight);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = CANCEL_FLIGHT)
    public ResponseEntity<HttpStatus> cancelFlight(@PathVariable Long id){
        inventoryService.cancelFlight(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
