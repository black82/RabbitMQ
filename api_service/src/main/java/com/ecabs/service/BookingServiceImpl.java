package com.ecabs.service;

import com.ecabs.model.Booking;
import com.ecabs.rabbit.TaskSender;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Service that receives booking from the REST client and sends them for elaboration through Rabitt to the consumer
 * </p>
 *
 * @author Railean Iurie
 */
@Component
public class BookingServiceImpl implements BookingService {

    private final TaskSender taskSender;

    public BookingServiceImpl(final TaskSender taskSender) {
        this.taskSender = taskSender;
    }

    public void messageSend(final String message) {
        this.taskSender.messageAudit(message);
    }

    /**
     * @param booking com.ecabs.model.Booking class<p> Create a message for processing microservice to saved this Booking.</p>
     */
    public void savedBooking(final Booking booking) {
        this.taskSender.savedBooking(booking);
    }

    /**
     * @param booking com.ecabs.model.Booking class <p> Create a message for processing microservice to delete this Booking.</p>
     */
    public void deleteBooking(final Booking booking) {
        this.taskSender.deleteBooking(booking);
    }

    /**
     * @param booking com.ecabs.model.Booking class<p> Create a message for processing microservice to update this Booking.</p>
     */
    public void editBooking(final Booking booking) {
        this.taskSender.editBooking(booking);
    }
}
