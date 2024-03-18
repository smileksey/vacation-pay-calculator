package com.smileksey.vacationpaycalculator.dto;

import java.math.BigDecimal;

public class CalculationResponse {
    private String message;
    private BigDecimal paymentValue;

    public CalculationResponse() {
    }

    public CalculationResponse(String message, BigDecimal calculationResult) {
        this.message = message;
        this.paymentValue = calculationResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(BigDecimal paymentValue) {
        this.paymentValue = paymentValue;
    }
}
