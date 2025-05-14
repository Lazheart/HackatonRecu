package com.example.demo.model;

import com.example.demo.exceptions.InsufficientStockException;
import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private int quantity; // Cantidad solicitada
    private int stock = 20; // Stock inicial fijo de 20 unidades
    private double price;

    // Método para reducir stock
    public void reduceStock() {
        if (this.quantity > this.stock) {
            throw new InsufficientStockException(
                    String.format("No hay suficiente stock. Producto: %s | Stock: %d | Solicitado: %d",
                            this.name, this.stock, this.quantity));
        }
        this.stock -= this.quantity;
    }
}
