package com.example.swimmingpoolservice.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.ZonedDateTime;
@Data
@Entity
public class CollectedData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer amountPeopleAtPool;
    private Integer amountOfFreeSpotsAtPool;
    private Integer amountPeopleAtSpa;
    private Integer amountOfFreeSpotsAtSpa;
    private ZonedDateTime downloadDate;
}
