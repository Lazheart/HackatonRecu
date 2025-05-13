package com.example.demo.Order;


import com.example.demo.Order.Repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final ApplicationEventPublisher eventPublisher;

    public OrderService(OrderRepository repository, ApplicationEventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public Order crearPedido(String email, List<String> productos) {
        Order order = new Order(email, productos);
        Order saved = repository.save(order); // guarda el pedido
        eventPublisher.publishEvent(new OrderCreatedEvent(this, saved.getId(), saved.getEmail(), saved.getProductos()));
        return saved;
    }
}
