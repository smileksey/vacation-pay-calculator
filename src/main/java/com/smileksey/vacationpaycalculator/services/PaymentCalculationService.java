package com.smileksey.vacationpaycalculator.services;

import com.smileksey.vacationpaycalculator.dto.CalculationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public interface PaymentCalculationService {

    CalculationResponse getVacationPayment(BigDecimal averageSalary, int amountOfDays);

    int getAmountOfPaidDays(LocalDate dateOfStart, int amountOfDays);

}
