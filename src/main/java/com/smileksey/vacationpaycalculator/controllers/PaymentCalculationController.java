package com.smileksey.vacationpaycalculator.controllers;

import com.smileksey.vacationpaycalculator.dto.CalculationResponse;
import com.smileksey.vacationpaycalculator.services.PaymentCalculationService;
import com.smileksey.vacationpaycalculator.services.PaymentCalculationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculate")
public class PaymentCalculationController {

    private final PaymentCalculationService paymentCalculationService;

    @Autowired
    public PaymentCalculationController(PaymentCalculationService paymentCalculationService) {
        this.paymentCalculationService = paymentCalculationService;
    }


    @GetMapping
    public CalculationResponse getCalculatedPayment(@RequestParam("avgsalary") BigDecimal averageSalary,
                                                    @RequestParam("days") int vacationDaysAmount) {

        return paymentCalculationService.getVacationPayment(averageSalary, vacationDaysAmount);
    }
}