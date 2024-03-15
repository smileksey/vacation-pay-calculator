package com.smileksey.vacationpaycalculator.services;

import com.smileksey.vacationpaycalculator.dto.CalculationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PaymentCalculationServiceImpl implements PaymentCalculationService {

    private final static Logger logger = LogManager.getLogger(PaymentCalculationServiceImpl.class);
    private static final double AVERAGE_AMOUNT_OF_DAYS_IN_MONTH = 29.3;

    @Override
    public CalculationResponse getVacationPayment(BigDecimal averageSalary, int amountOfDays) {

        logger.info("Расчет для: среднемесячная зарплата = {} руб., количество дней отпуска = {}", averageSalary, amountOfDays);

        BigDecimal averageSalaryPerDay = averageSalary.divide(BigDecimal.valueOf(AVERAGE_AMOUNT_OF_DAYS_IN_MONTH), 2, RoundingMode.HALF_UP);
        logger.info("Средняя зарплата за день составляет {}", averageSalaryPerDay);

        BigDecimal vacationPayment = averageSalaryPerDay.multiply(BigDecimal.valueOf(amountOfDays));
        logger.info("Отпускные выплаты составляют {}", vacationPayment);

        return new CalculationResponse("Размер отпускных выплат", vacationPayment);
    }

}
