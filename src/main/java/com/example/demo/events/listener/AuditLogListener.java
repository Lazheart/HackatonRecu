package com.example.demo.events.listener;

import com.example.demo.events.OrderCreatedEvent;
import org.apache.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;



@Component
public class AuditLogListener {
    private static final Logger logger = Logger.getLogger(AuditLogListener.class);

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {
        logger.info("Registrando en logs de auditoría el pedido " +
                event.getOrder().getId() + " con " +
                event.getOrder().getProducts().size() + " productos");
    }
}
