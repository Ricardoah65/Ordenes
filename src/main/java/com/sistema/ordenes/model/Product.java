package com.sistema.ordenes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "No puede estar vacio")
    private String name;

    @Column(name="description", nullable = false)
    @NotBlank(message = "No puede estar vacio")
    private String description;

    @Column(name = "price", nullable = false)
    @NotNull(message = "No puede ser nulo")
    @Positive(message = "Debe ser un número positivo")
    private Double price;

    @Column(name="stock", nullable = false)
    @NotBlank(message = "Dime cuantas hay disponibles")
    private int stock;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();

    public Product() {
    }

    public Product(Long id, String name, String description, Double price, int stock, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "No puede estar vacio") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "No puede estar vacio") String name) {
        this.name = name;
    }

    public @NotBlank(message = "No puede estar vacio") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "No puede estar vacio") String description) {
        this.description = description;
    }

    public @NotBlank(message = "No puede estar vacio") Double getPrice() {
        return price;
    }

    public void setPrice(@NotBlank(message = "No puede estar vacio") Double price) {
        this.price = price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @NotBlank(message = "Dime cuantas hay disponibles")
    public int getStock() {
        return stock;
    }

    public void setStock(@NotBlank(message = "Dime cuantas hay disponibles") int stock) {
        this.stock = stock;
    }
}

