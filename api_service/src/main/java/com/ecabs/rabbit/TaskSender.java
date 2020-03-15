package com.ecabs.rabbit;

import com.ecabs.model.Booking;
import org.springframework.stereotype.Service;

@Service
public interface TaskSender {
    void messageAudit(String message);

    void editBooking(Booking booking);

    void deleteBooking(Booking booking);

    void savedBooking(Booking booking);
}
