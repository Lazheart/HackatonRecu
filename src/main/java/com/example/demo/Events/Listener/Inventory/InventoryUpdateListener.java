package com.example.demo.Events.Listener.Inventory;

import com.example.demo.Events.Listener.OrderCreatedEvent;
import com.example.demo.producto.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {

    private final ProductoService productoService;
    private static final Logger logger = LoggerFactory.getLogger(InventoryUpdateListener.class);

    public InventoryUpdateListener(ProductoService productoService) {
        this.productoService = productoService;
    }

    @EventListener
    public void manejarActualizacionInventario(OrderCreatedEvent event) {
        for (String producto : event.getProductos()) {
            logger.info("Reduciendo stock para el producto: {}", producto);
            productoService.reducirStock(producto);
        }
    }
}

