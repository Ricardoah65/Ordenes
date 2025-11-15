package com.sistema.ordenes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class userResponseDto {
    @NotBlank(message = "No puede estar vacio")
    private Long idUser;
    @NotBlank(message = "No puede estar vacio")
    private String name;
    @NotBlank(message = "No puede estar vacio")
    private String lastname;
    @Email
    private String email;
    @NotBlank(message = "No puede estar vacio")
    private String telephone;
    @NotBlank(message = "No puede estar vacio")
    private String address;

    public userResponseDto() {
    }

    public userResponseDto(Long idUser, String name, String lastname, String email, String telephone, String address) {
        this.idUser = idUser;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
