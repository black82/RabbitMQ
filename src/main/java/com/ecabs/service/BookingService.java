package com.ecabs.service;

import com.ecabs.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BookingService {
    Booking getBookingById(final UUID id);

    List<Booking> getAllBooking();

    void savedBooking(final Booking booking);

    void deleteBookingById(final UUID id);
}
