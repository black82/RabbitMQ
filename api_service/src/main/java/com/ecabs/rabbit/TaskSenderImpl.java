package com.ecabs.rabbit;
import com.ecabs.model.Booking;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <p>
 * Creating messages and sending them through RabbitMq to the consumer.
 * </p>
 *
 * @author Railean Iurie
 */
@EnableRabbit
@Service
public class TaskSenderImpl implements com.ecabs.rabbit.TaskSender {

    private final RabbitTemplate template;


    @Autowired
    public TaskSenderImpl(final RabbitTemplate template) {
        this.template = template;
    }

    /**
     * @param message java.lang.String class<p> Creating the message in the AuditMessages topic.</p>
     */
    public void messageAudit(final String message) {
        this.template.convertAndSend("MessageExchange", "message", message);
    }

    /**
     * @param booking com.ecabs.model.Booking class<p> Creating the message in the AuditMessages topic.</p>
     */
    public void savedBooking(final Booking booking) {
        this.template.convertAndSend("MessageExchange", "addQueue", this.mapBookingToJason(booking));

    }

    /**
     * @param booking com.ecabs.model.Booking class<p> Creating the message in the DeleteQueue topic.</p>
     */
    public void deleteBooking(final Booking booking) {
        this.template.convertAndSend("MessageExchange", "deleteQueue", this.mapBookingToJason(booking));
    }

    /**
     * @param booking com.ecabs.model.Booking class<p> Creating the message in the EditQueue topic.</p>
     */
    public void editBooking(final Booking booking) {
        this.template.convertAndSend("MessageExchange", "editQueue", this.mapBookingToJason(booking));
    }

    /**
     * @param booking com.ecabs.model.Booking class<p> Converting of the Booking object into Json java.lang.String</p>
     */
    synchronized public String mapBookingToJason(Booking booking) {
        Gson gson = new Gson();
        return gson.toJson(booking);
    }

}
