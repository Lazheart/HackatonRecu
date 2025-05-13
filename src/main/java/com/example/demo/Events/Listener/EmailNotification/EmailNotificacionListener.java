package com.example.demo.Events.Listener.EmailNotification;

import com.example.demo.Events.Listener.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificacionListener {

    private static final Logger logger = LoggerFactory.getLogger(EmailNotificacionListener.class);

    @EventListener
    public void manejarConfirmacionDePedido(OrderCreatedEvent event) {
        logger.info("Simulando envío de correo de confirmación a {} por el pedido con ID: {} y productos: {}",
                event.getEmail(), event.getOrder(), event.getProductos());
    }
}
