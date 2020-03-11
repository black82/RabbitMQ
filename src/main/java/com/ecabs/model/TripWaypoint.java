package com.ecabs.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Data
@Table(name = "TRIP_WAY_POINT")
@Entity
public class TripWaypoint {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "TRIP_WAY_POINT_ID")
    private UUID tripWayPointId;
    @Column(name = "LAST_STOP")
    private Boolean lastStop;
    @Column(name = "LOCALITY")
    private String locality;
    @Column(name = "LATITUDE")
    private Double lat;
    @Column(name = "LONGITUDE")
    private Double lng;
    @Column(name = "TRIP_WAY_POINT_TIMESTAMP")
    private Instant tripWayPointTimestamp;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookingId")
    private Booking booking;
}
