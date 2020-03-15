package com.ecabs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripWaypoint {
    private UUID tripWayPointId;
    private Boolean lastStop;
    private String locality;
    private Double lat;
    private Double lng;
    private Instant tripWayPointTimestamp;
    private Booking booking;
}
