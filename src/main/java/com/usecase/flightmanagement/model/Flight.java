package com.usecase.flightmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Builder
public class Flight {
    private Long id;
    private String name;
    private String route;
    private Timestamp departure;
    private String status;
}
