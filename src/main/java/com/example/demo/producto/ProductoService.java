package com.example.demo.producto;

import com.example.demo.producto.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public void reducirStock(String nombreProducto) {
        Optional<Producto> optionalProducto = repository.findByNombre(nombreProducto);
        optionalProducto.ifPresent(producto -> {
            if (producto.getStock() > 0) {
                producto.setStock(producto.getStock() - 1);
                repository.save(producto);
            }
        });
    }
}

