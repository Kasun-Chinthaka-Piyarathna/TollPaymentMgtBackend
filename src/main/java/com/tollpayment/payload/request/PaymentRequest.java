package com.tollpayment.payload.request;

import jakarta.validation.constraints.NotBlank;

public class PaymentRequest {

    @NotBlank
    private String id;
    @NotBlank
    private String transaction_time;

    private Double payment;

    public String getTransaction_time() {
        return transaction_time;
    }

    public void setTransaction_time(String transaction_time) {
        this.transaction_time = transaction_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }
}
