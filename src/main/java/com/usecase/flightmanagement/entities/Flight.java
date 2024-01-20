package com.usecase.flightmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "flights")
@Entity
@Data
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
}
