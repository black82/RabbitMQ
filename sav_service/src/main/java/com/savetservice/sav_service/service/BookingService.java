package com.savetservice.sav_service.service;

import com.savetservice.sav_service.model.Booking;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    void savedBooking(final Booking booking);

    void deleteBooking(final Booking booking);
}
