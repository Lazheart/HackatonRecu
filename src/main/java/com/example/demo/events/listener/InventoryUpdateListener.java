package com.example.demo.events.listener;

import com.example.demo.events.OrderCreatedEvent;
import com.example.demo.exceptions.InsufficientStockException;
import com.example.demo.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryUpdateListener {

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) throws InsufficientStockException {
        log.info("Procesando actualización de inventario para el pedido: {}", event.getOrder().getId());

        for (Product product : event.getOrder().getProducts()) {
            try {
                log.info("Producto: {} | Stock actual: {} | Cantidad solicitada: {}",
                        product.getName(), product.getStock(), product.getQuantity());

                product.reduceStock();

                log.info("Stock actualizado - Producto: {} | Nuevo stock: {}",
                        product.getName(), product.getStock());

            } catch (InsufficientStockException e) {
                log.error("ERROR en actualización de inventario: {}", e.getMessage());
                throw e;
            }
        }
    }
}