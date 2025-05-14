package com.example.demo.model;

import com.example.demo.exceptions.InsufficientStockException;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private int stock = 20; // Valor por defecto
    private double price;

    private transient int quantity; // Solo para pedidos

    public void reduceStock() {
        if (this.quantity > this.stock) {
            throw new InsufficientStockException(
                    String.format("No hay suficiente stock. Producto: %s | Stock: %d | Solicitado: %d",
                            this.name, this.stock, this.quantity));
        }
        this.stock -= this.quantity;
    }
}