package com.example.demo.Order;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @ElementCollection
    @CollectionTable(name = "order_productos", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "producto")
    private List<String> productos;

    public Order(String email, List<String> productos) {
        this.email = email;
        this.productos = productos;

    }
}