package com.savetservice.sav_service.customexeption;

public class BookingNotFound extends RuntimeException {
    public BookingNotFound(final String s) {
        super(s);
    }
}
