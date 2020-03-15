package com.savetservice.sav_service.service;


import com.savetservice.sav_service.model.Booking;
import com.savetservice.sav_service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
     * @param booking <p> Save the Booking to the DB</p>
     */
    public void savedBooking(final Booking booking) {
        this.bookingRepo.save(booking);
    }

    /**
     * @param id <p> Delete Booking to Db.</p>
     */
    public void deleteBooking(final Booking booking) {
        this.bookingRepo.delete(booking);
    }
}
