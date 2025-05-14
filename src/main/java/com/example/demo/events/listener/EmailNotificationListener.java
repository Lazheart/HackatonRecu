package com.example.demo.events.listener;

import com.example.demo.events.OrderCreatedEvent;
import org.apache.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {
    private static final Logger logger = Logger.getLogger(EmailNotificationListener.class);

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {
        logger.info("Enviando correo de confirmación para el pedido " +
                event.getOrder().getId() + " al email " +
                event.getOrder().getEmail());
    }
}