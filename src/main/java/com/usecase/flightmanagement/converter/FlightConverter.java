package com.usecase.flightmanagement.converter;

import com.usecase.flightmanagement.model.Flight;

public class FlightConverter {

    public static Flight convertEntityToDto(com.usecase.flightmanagement.entities.Flight flight){
        return Flight.builder().id(flight.getId())
                .name(flight.getName())
                .route(flight.getRoute())
                .departure(flight.getDeparture())
                .status(flight.getStatus())
                .build();
    }

    public static com.usecase.flightmanagement.entities.Flight convertDtoToEntity(Flight flight){
        com.usecase.flightmanagement.entities.Flight flightEntity = new com.usecase.flightmanagement.entities.Flight();
        flightEntity.setName(flight.getName());
        flightEntity.setRoute(flight.getRoute());
        flightEntity.setDeparture(flight.getDeparture());
        flightEntity.setStatus(flight.getStatus());
        return flightEntity;
    }
}
