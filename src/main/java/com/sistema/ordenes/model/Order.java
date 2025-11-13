package com.sistema.ordenes.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Long idOrder;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "additional_notes", nullable = false)
    private String additionalNotes;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    //Muchas ordenes puede tener muchos pedidos
    @ManyToMany()
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns =@JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<Product>();

    public Order() {
    }

    public Order(Long idOrder, LocalDateTime date, String additionalNotes, User user, List<Product> products) {
        this.idOrder = idOrder;
        this.date = date;
        this.additionalNotes = additionalNotes;
        this.user = user;
        this.products = products;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    //Constructor, getters y setters

}
