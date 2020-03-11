package com.ecabs.controller;

import com.ecabs.model.Booking;
import com.ecabs.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * Controller the basic CRUD services.
 * </p>
 *
 * @author Railean Iurie
 */
@RestController
@RequestMapping(value = "api/",
        method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class BookingRestController {
    private final BookingService bookingService;

    @Autowired
    public BookingRestController(final BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping(params = "id",
            value = "booking")
    public ResponseEntity<Booking> searchBookingById(@Param("id") final UUID id) {
        return ResponseEntity
                .ok(bookingService.getBookingById(id));
    }

    @GetMapping("all/booking")
    public ResponseEntity<List<Booking>> getAllBooking() {
        return ResponseEntity.
                ok(bookingService.getAllBooking());
    }

    @PostMapping("save/booking")
    public ResponseEntity<HttpStatus> createBooking(@RequestBody final Booking booking) {
        bookingService.savedBooking(booking);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("update/booking")
    public ResponseEntity<HttpStatus> updateBooking(@RequestBody final Booking booking) {
        bookingService.savedBooking(booking);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("delete/booking")
    public ResponseEntity<HttpStatus> deleteBooking(@RequestBody final UUID id) {
        bookingService.deleteBookingById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
