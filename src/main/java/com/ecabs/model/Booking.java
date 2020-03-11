package com.ecabs.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "BOOKING")
@Entity
public class Booking {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "BOOKING_ID")
    private UUID bookingId;
    @Column(name = "PASSENGER_NAME", length = 50, nullable = false)
    private String passengerName;
    @Column(name = "PASSENGER_CONTACT_NUMBER", length = 15)
    private String passengerContactNumber;
    @Column(name = "PICKUP_TIME")
    private OffsetDateTime pickupTime;
    @Column(name = "ASAP")
    private Boolean asap = true;
    @Column(name = "WAITING_TIME")
    private Integer waitingTime;
    @Column(name = "NO_OF_PASSENGERS", length = 100)
    private Integer noOfPassengers;
    @Column(name = "PRICE", length = 7, nullable = false)
    private BigDecimal price;
    @Column(name = "RATING", length = 3)
    private Integer rating;
    @Column(name = "CREATED_ON", columnDefinition = "TIMESTAMP")
    private Instant createdOn;
    @Column(name = "LAST_MODIFIED_ON", columnDefinition = "TIMESTAMP")
    private Instant lastModifiedOn;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "booking")
    private List<TripWaypoint> tripWayPoints;
}
