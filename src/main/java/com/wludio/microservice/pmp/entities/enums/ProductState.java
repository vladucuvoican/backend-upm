package com.wludio.microservice.pmp.entities.enums;

import lombok.Getter;

@Getter
public enum ProductState {
    IN_STOCK("IN STOCK"),
    OUT_OF_STOCK("OUT OF STOCK");

    private String type;

    ProductState(String type) {
        this.type = type;
    }
}
