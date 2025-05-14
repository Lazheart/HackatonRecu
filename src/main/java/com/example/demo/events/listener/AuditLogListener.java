package com.example.demo.events.listener;

import com.example.demo.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuditLogListener {

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {
        log.info("Registrando en logs de auditoría el pedido {} con {} productos",
                event.getOrder().getId(),
                event.getOrder().getProducts().size());

        log.debug("Detalles completos de auditoría: {}", event.getOrder());
    }
}