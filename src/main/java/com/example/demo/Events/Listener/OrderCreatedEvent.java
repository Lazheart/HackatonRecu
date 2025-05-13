package com.example.demo.Events.Listener;

import org.springframework.context.ApplicationEvent;

import java.util.List;

public class OrderCreatedEvent extends ApplicationEvent {

    private final Long id;
    private final String email;
    private final List<String> productos;

    public OrderCreatedEvent(Object source, Long id, String email, List<String> productos) {
        super(source);
        this.id = id;
        this.email = email;
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getProductos() {
        return productos;
    }

    public Object getOrder() {
        return id;
    }
}

