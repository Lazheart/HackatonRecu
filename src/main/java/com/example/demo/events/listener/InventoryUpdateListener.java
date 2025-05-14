package com.example.demo.events.listener;

import com.example.demo.events.OrderCreatedEvent;
import com.example.demo.exceptions.InsufficientStockException;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import lombok.extern.log4j.Log4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class InventoryUpdateListener {

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) throws InsufficientStockException {
        Order order = event.getOrder();
        log.info("Procesando pedido ID: " + order.getId());

        for (Product product : order.getProducts()) {
            try {
                log.info(String.format("Validando stock - Producto: %s | Stock: %d | Cantidad: %d",
                        product.getName(), product.getStock(), product.getQuantity()));

                product.reduceStock();

                log.info(String.format("Stock actualizado - Producto: %s | Nuevo stock: %d",
                        product.getName(), product.getStock()));

            } catch (InsufficientStockException e) {
                log.error("Error en pedido " + order.getId() + ": " + e.getMessage());
                throw e; // Propaga la excepción para que OrderService la capture
            }
        }
    }
}