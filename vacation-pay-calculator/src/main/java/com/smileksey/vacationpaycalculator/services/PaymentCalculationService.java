package com.smileksey.vacationpaycalculator.services;

import com.smileksey.vacationpaycalculator.dto.CalculationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface PaymentCalculationService {

    public CalculationResponse getVacationPayment(BigDecimal averageSalary, int amountOfDays);

}
