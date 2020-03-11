package com.ecabs.customexeption;

public class BookingNotFound extends RuntimeException {
    public BookingNotFound(final String s) {
        super(s);
    }
}
