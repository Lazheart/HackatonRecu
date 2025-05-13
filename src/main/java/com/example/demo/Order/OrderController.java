package com.example.demo.Order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> crearPedido(@RequestBody Order order) {
        Order saved = orderService.crearPedido(order.getEmail(), order.getProductos());
        return ResponseEntity.ok("Pedido recibido con ID: " + saved.getId());
    }
}