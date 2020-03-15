package com.ecabs.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @JsonSerialize(using = UUIDSerializer.class)
    @JsonDeserialize(contentUsing = UUIDDeserializer.class)
    private UUID bookingId;
    private String passengerName;
    private String passengerContactNumber;
    private OffsetDateTime pickupTime;
    private Boolean asap;
    private Integer waitingTime;
    private Integer noOfPassengers;
    private BigDecimal price;
    private Integer rating;
    private Instant createdOn;
    private Instant lastModifiedOn;
    private List<TripWaypoint> tripWayPoints;
}
