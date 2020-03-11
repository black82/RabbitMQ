package com.ecabs.service;

import com.ecabs.customexeption.BookingNotFound;
import com.ecabs.model.Booking;
import com.ecabs.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * <p>
 * Implement the basic CRUD services.
 * </p>
 *
 * @author Railean Iurie
 */
@Component
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;

    @Autowired
    public BookingServiceImpl(final BookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    /**
     * <p>
     * Description of the method
     * </p>
     *
     * @param id Id of the searched object
     * @return Booking sought or throwing a BookingNotFound exception.
     */
    public Booking getBookingById(final UUID id) {
        final Optional<Booking> bookingOptional = bookingRepo.findById(id);
        if (bookingOptional.isPresent()) {
            return bookingOptional.get();
        } else {
            throw new BookingNotFound("Booking sought after Id was not found.");
        }
    }

    /**
     * <p> Description of the method</p>
     *
     * @return Return all bookings present in the DB.
     */
    public List<Booking> getAllBooking() {
        return bookingRepo.findAll();
    }

    /**
     * <p> Save the Booking to the DB</p>
     */
    public void savedBooking(final Booking booking) {
        bookingRepo.save(booking);
    }

    /**
     * <p> Delete Booking to Db.</p>
     */
    public void deleteBookingById(final UUID id) {
        bookingRepo.deleteById(id);
    }
}
