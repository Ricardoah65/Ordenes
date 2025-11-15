package com.sistema.ordenes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "No puede estar vacio")
    private String name;

    @Column(name = "lastname", nullable = false)
    @NotBlank(message = "No puede estar vacio")
    private String lastname;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "No puede estar vacio")
    private String email;

    @Column(name = "telephone", nullable = false)
    @NotBlank(message = "No puede estar vacio")
    private String telephone;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "No puede estar vacio")
    private String password;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "No puede estar vacio")
    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Long idUser, String name, String lastname, String email, String telephone, String password, String address, List<Order> orders) {
        this.idUser = idUser;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.address = address;
        this.orders = orders;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public @NotBlank(message = "No puede estar vacio") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "No puede estar vacio") String name) {
        this.name = name;
    }

    public @NotBlank(message = "No puede estar vacio") String getLastname() {
        return lastname;
    }

    public void setLastname(@NotBlank(message = "No puede estar vacio") String lastname) {
        this.lastname = lastname;
    }

    public @NotBlank(message = "No puede estar vacio") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "No puede estar vacio") String email) {
        this.email = email;
    }

    public @NotBlank(message = "No puede estar vacio") String getTelephone() {
        return telephone;
    }

    public void setTelephone(@NotBlank(message = "No puede estar vacio") String telephone) {
        this.telephone = telephone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public @NotBlank(message = "No puede estar vacio") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "No puede estar vacio") String password) {
        this.password = password;
    }

    public @NotBlank(message = "No puede estar vacio") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "No puede estar vacio") String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }


}
