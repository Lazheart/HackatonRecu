package com.example.demo.controller;

import com.example.demo.exceptions.InsufficientStockException;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        try {
            orderService.processOrder(order);
            return ResponseEntity.ok().body("Pedido procesado exitosamente");
        } catch (InsufficientStockException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ProductNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al procesar el pedido");
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        orderService.createProduct(product);
        return ResponseEntity.noContent().build();
    }
}