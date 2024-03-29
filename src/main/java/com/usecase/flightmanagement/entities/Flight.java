package com.usecase.flightmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Table(name = "FLIGHT")
@Entity
@Data
public class Flight {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "route")
    private String route;

    @Column(name = "departure")
    private Timestamp departure;

    @Column(name = "status")
    private String status;
}
