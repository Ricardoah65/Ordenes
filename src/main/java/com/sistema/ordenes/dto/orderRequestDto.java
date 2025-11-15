package com.sistema.ordenes.dto;

import java.util.List;

public class orderRequestDto {
    private Long userId;
    private List<Long> productsId;
    private String additionalNotes;

    public orderRequestDto() {
    }

    public orderRequestDto(Long userId, List<Long> productsId, String additionalNotes) {
        this.userId = userId;
        this.productsId = productsId;
        this.additionalNotes = additionalNotes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Long> productsId) {
        this.productsId = productsId;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}
