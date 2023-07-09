package com.example.swimmingpoolservice.controllers.dto;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ZonedDateTimeRequest {
    private ZonedDateTime dateFrom;
    private ZonedDateTime dateTo;
}
