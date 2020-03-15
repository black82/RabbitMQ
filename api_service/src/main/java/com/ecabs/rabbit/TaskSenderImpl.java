package com.ecabs.rabbit;


import com.ecabs.model.Booking;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@EnableRabbit
@Service
public class TaskSenderImpl implements TaskSender {

    private final RabbitTemplate template;


    @Autowired
    public TaskSenderImpl(final RabbitTemplate template) {
        this.template = template;
    }

    public void messageAudit(final String message) {
        this.template.convertAndSend("MessageExchange", "message", message);
    }

    public void savedBooking(final Booking booking) {
        this.template.convertAndSend("MessageExchange", "addQueue", this.mapBookingToJason(booking));

    }

    public void deleteBooking(final Booking booking) {
        this.template.convertAndSend("MessageExchange", "deleteQueue", this.mapBookingToJason(booking));
    }

    public void editBooking(final Booking booking) {
        this.template.convertAndSend("MessageExchange", "editQueue", this.mapBookingToJason(booking));
    }

    synchronized public String mapBookingToJason(Booking booking) {
        Gson gson = new Gson();
        return gson.toJson(booking);
    }

}
