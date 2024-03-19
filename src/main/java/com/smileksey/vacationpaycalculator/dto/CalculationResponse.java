package com.smileksey.vacationpaycalculator.dto;

import java.math.BigDecimal;

public class CalculationResponse {
    private BigDecimal paymentValue;

    public CalculationResponse() {
    }

    public CalculationResponse(BigDecimal calculationResult) {
        this.paymentValue = calculationResult;
    }

    public BigDecimal getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(BigDecimal paymentValue) {
        this.paymentValue = paymentValue;
    }
}
