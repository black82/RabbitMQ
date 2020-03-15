package com.savetservice.sav_service.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitQueueInitialize {

    @Bean(name = "messageAuditQueue")
    public Queue messageAuditQueue() {
        return new Queue("MessageAuditQueue");
    }

    @Bean(name = "messageExchange")

    public DirectExchange directExchange() {
        return new DirectExchange("MessageExchange");
    }

    @Bean(name = "bookingAddQueue")
    public Queue bookingAddQueue() {
        return new Queue("BookingAddQueue");
    }

    @Bean(name = "bookingEditQueue")
    public Queue bookingEditQueue() {
        return new Queue("BookingEditQueue");
    }

    @Bean(name = "bookingDeleteQueue")
    public Queue bookingDeleteQueue() {
        return new Queue("BookingDeleteQueue");
    }

    @Bean
    @Qualifier("messageAuditQueue")
    public Binding messageAuditQueueBuilder(Queue messageAuditQueue, Exchange messageExchange) {
        return BindingBuilder.bind(messageAuditQueue).to(messageExchange).with("message").noargs();

    }

    @Bean
    @Qualifier("bookingAddQueue")
    public Binding bookingAddQueueBuilder(Queue bookingAddQueue, Exchange directExchange) {
        return BindingBuilder.bind(bookingAddQueue).to(directExchange).with("addQueue").noargs();
    }

    @Bean
    @Qualifier("bookingEditQueue")
    public Binding bookingEditQueueBuilder(Queue bookingEditQueue, Exchange directExchange) {
        return BindingBuilder.bind(bookingEditQueue).to(directExchange).with("editQueue").noargs();
    }

    @Bean
    @Qualifier("bookingDeleteQueue")
    public Binding bookingDeleteQueueBuilder(Queue bookingDeleteQueue, Exchange directExchange) {
        return BindingBuilder.bind(bookingDeleteQueue).to(directExchange).with("deleteQueue").noargs();
    }
}
