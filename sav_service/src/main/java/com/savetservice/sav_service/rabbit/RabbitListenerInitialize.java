package com.savetservice.sav_service.rabbit;


import com.google.gson.Gson;
import com.savetservice.sav_service.model.Booking;
import com.savetservice.sav_service.service.BookingService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitListenerInitialize {
    private final BookingService bookingService;

    public RabbitListenerInitialize(final BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RabbitListener(queues = {"MessageAuditQueue"})
    public void messageAuditListener(String s) {
        System.out.println(s);
    }

    @RabbitListener(queues = {"BookingAddQueue"})
    public void bookingAddListener(final String booking) {
        this.bookingService.savedBooking(this.mapJasonToBooking(booking));
        System.out.println(booking);
    }

    @RabbitListener(queues = {"BookingEditQueue"})
    public void bookingEditListener(final String booking) {
        this.bookingService.savedBooking(this.mapJasonToBooking(booking));
    }

    @RabbitListener(queues = {"BookingDeleteQueue"})
    public void bookingDeleteListener(final String booking) {
        this.bookingService.deleteBooking(this.mapJasonToBooking(booking));

    }

    synchronized private Booking mapJasonToBooking(final String booking) {
        Gson gson = new Gson();
        return gson.fromJson(booking, Booking.class);
    }
}
