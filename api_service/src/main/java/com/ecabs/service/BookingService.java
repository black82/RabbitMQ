package com.ecabs.service;

import com.ecabs.model.Booking;
import org.springframework.stereotype.Service;
/**
 * <p>
 * Interface service for implementation. To guarantee the users these implementation.
 * </p>
 *
 * @author Railean Iurie
 */
@Service
public interface BookingService {

    void savedBooking(final Booking booking);

    void deleteBooking(final Booking booking);

    void messageSend(final String message);

    void editBooking(final Booking booking);
}
