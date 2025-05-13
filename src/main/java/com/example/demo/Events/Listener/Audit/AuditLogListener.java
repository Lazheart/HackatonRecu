package com.example.demo.Events.Listener.Audit;

import com.example.demo.Events.Listener.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener {

    private static final Logger logger = LoggerFactory.getLogger(AuditLogListener.class);

    @EventListener
    public void registrarAuditoria(OrderCreatedEvent event) {
        logger.info("AUDITORÍA - Pedido registrado: ID={}, Email={}, Productos={}",
                event.getOrder(), event.getEmail(), event.getProductos());
    }
}
