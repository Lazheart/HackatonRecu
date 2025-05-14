package com.example.demo.service;

import com.example.demo.events.OrderCreatedEvent;
import com.example.demo.exceptions.InsufficientStockException;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public OrderService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void processOrder(Order order) throws InsufficientStockException {
        try {
            // Publicar el evento que activará los listeners
            eventPublisher.publishEvent(new OrderCreatedEvent(this, order));
        } catch (Exception e) {
            if (e.getCause() instanceof InsufficientStockException) {
                throw (InsufficientStockException) e.getCause();
            }
            throw new RuntimeException("Error al procesar el pedido", e);
        }
    }
}
