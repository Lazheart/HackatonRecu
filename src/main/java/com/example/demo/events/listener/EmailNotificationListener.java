package com.example.demo.events.listener;

import com.example.demo.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailNotificationListener {

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {
        log.info("Enviando correo de confirmación para el pedido {} al email {}",
                event.getOrder().getId(),
                event.getOrder().getEmail());

        // Simulación de lógica de envío de correo
        log.debug("Detalles completos del correo: {}", event.getOrder());
    }
}