package com.smileksey.vacationpaycalculator.dto;

import java.math.BigDecimal;

public class CalculationResponse {
    private String message;
    private BigDecimal calculationResult;

    public CalculationResponse() {
    }

    public CalculationResponse(String message, BigDecimal calculationResult) {
        this.message = message;
        this.calculationResult = calculationResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getCalculationResult() {
        return calculationResult;
    }

    public void setCalculationResult(BigDecimal calculationResult) {
        this.calculationResult = calculationResult;
    }
}
