package com.example.demo.Events.Listener.Inventory;

import com.example.demo.Events.Listener.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {

    private static final Logger logger = LoggerFactory.getLogger(InventoryUpdateListener.class);

    @EventListener
    public void manejarActualizacionInventario(OrderCreatedEvent event) {
        logger.info("Reduciendo stock por el pedido ID: {}. Productos: {}", event.getOrder(), event.getProductos());
    }
}
