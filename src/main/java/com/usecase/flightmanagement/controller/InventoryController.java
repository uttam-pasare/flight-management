package com.usecase.flightmanagement.controller;

import com.usecase.flightmanagement.model.Flight;
import com.usecase.flightmanagement.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.usecase.flightmanagement.constants.ApiConstants.GET_FLIGHTS;
import static com.usecase.flightmanagement.constants.ApiConstants.INVENTORY_MAPPING;
@RestController
@RequestMapping(INVENTORY_MAPPING)
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping(value = GET_FLIGHTS)
    public ResponseEntity<List<Flight>> flights(){
        List<Flight> flights = inventoryService.getAllFlights();
        if(CollectionUtils.isEmpty(flights)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}
