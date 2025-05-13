package com.example.demo.Events.Listener;

import com.example.demo.Order.Order;
import com.example.demo.Order.OrderService;
import jakarta.validation.constraints.Email;
import org.springframework.context.ApplicationEvent;

import java.util.List;


public class OrderCreatedEvent extends ApplicationEvent {
    public OrderCreatedEvent(OrderService orderService, Long id, @Email String email, List<String> productos) {
                super(orderService);
        order = null;
    }

    public Long getId() {
        return Id;
    }

    public String getEmail() {
        return Email;
    }

    public String getProductos() {
        return Productos;
    }

    private Long Id;
    private String Email;
    private String Productos;

    private final Order order;
    public OrderCreatedEvent(Object source, Order order) {
        super(order);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }


}
