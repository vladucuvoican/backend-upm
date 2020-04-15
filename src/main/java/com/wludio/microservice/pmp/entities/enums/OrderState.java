package com.wludio.microservice.pmp.entities.enums;

public enum OrderState {
    CREATED,
    PAYMENT_REQUESTED,
    PAYMENT_FAILED,
    CONFIRMED,
    PROCESSING,
    PREPARING_FOR_DISPATCHING,
    DISPATCHED;
}
