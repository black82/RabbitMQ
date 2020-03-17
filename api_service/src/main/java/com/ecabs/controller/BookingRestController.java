package com.ecabs.controller;
import com.ecabs.model.Booking;
import com.ecabs.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * RestController Client.
 * </p>
 *
 * @author Railean Iurie
 */
@RestController
@RequestMapping(value = "api/")
public class BookingRestController {
    private final BookingService bookingService;

    @Autowired
    public BookingRestController(final BookingService bookingService) {
        this.bookingService = bookingService;
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
    public ResponseEntity<HttpStatus> deleteBooking(@RequestBody final Booking booking) {
        bookingService.deleteBooking(booking);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PostMapping("/message/audit")
    public ResponseEntity<HttpStatus> messageAudit(@RequestBody String message) {
        this.bookingService.messageSend(message);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
