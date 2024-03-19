package com.smileksey.vacationpaycalculator.controllers;

import com.smileksey.vacationpaycalculator.dto.CalculationResponse;
import com.smileksey.vacationpaycalculator.services.PaymentCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/calculate")
public class PaymentCalculationController {

    private final PaymentCalculationService paymentCalculationService;

    @Autowired
    public PaymentCalculationController(PaymentCalculationService paymentCalculationService) {
        this.paymentCalculationService = paymentCalculationService;
    }

    @GetMapping
    public CalculationResponse getCalculatedPayment(@RequestParam("avgSalary") BigDecimal averageSalary,
                                                    @RequestParam("days") int amountOfDays,
                                                    @RequestParam("dateOfStart") @DateTimeFormat(pattern = "dd-MM-yyyy") Optional<LocalDate> dateOfStart) {

        if (dateOfStart.isPresent()) {
            amountOfDays = paymentCalculationService.getAmountOfPaidDays(dateOfStart.get(), amountOfDays);
        }

        return paymentCalculationService.getVacationPayment(averageSalary, amountOfDays);
    }
}
