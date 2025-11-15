package com.sistema.ordenes.dto;

import java.time.LocalDateTime;
import java.util.List;

public class orderResponseDto {
    private Long idOrder;
    private LocalDateTime date;
    private String additionalNotes;
    private String username;
    private List<String> productNames;

    public orderResponseDto() {
    }

    public orderResponseDto(Long idOrder, LocalDateTime date, String additionalNotes, String username, List<String> productNames) {
        this.idOrder = idOrder;
        this.date = date;
        this.additionalNotes = additionalNotes;
        this.username = username;
        this.productNames = productNames;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }
}
