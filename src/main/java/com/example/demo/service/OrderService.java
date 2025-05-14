package com.example.demo.service;

import com.example.demo.events.OrderCreatedEvent;
import com.example.demo.exceptions.InsufficientStockException;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final ApplicationEventPublisher eventPublisher;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(ApplicationEventPublisher eventPublisher,
                        ProductRepository productRepository) {
        this.eventPublisher = eventPublisher;
        this.productRepository = productRepository;
    }

    @Transactional
    public void processOrder(Order order) throws InsufficientStockException, ProductNotFoundException {
        // Verificar que todos los productos existan
        for (Product orderProduct : order.getProducts()) {
            Product dbProduct = productRepository.findById(orderProduct.getId())
                    .orElseThrow(() -> new ProductNotFoundException(
                            "Producto no encontrado: " + orderProduct.getId()));

            // Actualizar el producto del pedido con los datos reales
            orderProduct.setName(dbProduct.getName());
            orderProduct.setPrice(dbProduct.getPrice());
            orderProduct.setStock(dbProduct.getStock());
        }

        eventPublisher.publishEvent(new OrderCreatedEvent(this, order));
    }

    @Transactional
    public void createProduct(Product product) {
        // Establecer stock inicial si no viene definido
        if (product.getStock() <= 0) {
            product.setStock(20); // Stock por defecto
        }
        productRepository.save(product);
    }
}