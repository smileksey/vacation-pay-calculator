package com.smileksey.vacationpaycalculator.services;

import com.smileksey.vacationpaycalculator.dto.CalculationResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PaymentCalculationServiceImpl implements PaymentCalculationService {

    private final static Logger logger = LogManager.getLogger(PaymentCalculationServiceImpl.class);
    private static final double AVERAGE_AMOUNT_OF_DAYS_IN_MONTH = 29.3;

    @Override
    public CalculationResponse getVacationPayment(BigDecimal averageSalary, int amountOfDays) {

        logger.info("Расчет для: среднемесячная зарплата = {} руб., количество дней отпуска = {}", averageSalary, amountOfDays);

        BigDecimal averageSalaryPerDay = averageSalary.divide(BigDecimal.valueOf(AVERAGE_AMOUNT_OF_DAYS_IN_MONTH), 2, RoundingMode.HALF_UP);
        logger.info("Средняя зарплата за день составляет {}", averageSalaryPerDay);

        BigDecimal paymentValue = averageSalaryPerDay.multiply(BigDecimal.valueOf(amountOfDays));
        logger.info("Отпускные выплаты составляют {}", paymentValue);

        return new CalculationResponse("Размер отпускных выплат", paymentValue);
    }

    //обычные выходные не учитываем, т.к. отпуск берется по календарным дням
    public int getAmountOfPaidDays(LocalDate dateOfStart, int amountOfDays) {

        List<LocalDate> paidDays = Stream
                .iterate(dateOfStart, nextDate -> nextDate.plusDays(1))
                .limit(amountOfDays)
                .filter(thisDate -> !getListOfHolidays().contains(thisDate))
                .collect(Collectors.toList());

        logger.info("Количество оплачиваемых дней отпуска = {}, всего дней отпуска = {}, дата начала = {}", paidDays.size(), amountOfDays, dateOfStart);

        return paidDays.size();
    }

    private List<LocalDate> getListOfHolidays() {

        int currentYear = LocalDate.now().getYear();

        return List.of(
                LocalDate.of(currentYear, 1, 1),
                LocalDate.of(currentYear, 1, 2),
                LocalDate.of(currentYear, 1, 3),
                LocalDate.of(currentYear, 1, 4),
                LocalDate.of(currentYear, 1, 5),
                LocalDate.of(currentYear, 1, 6),
                LocalDate.of(currentYear, 1, 7),
                LocalDate.of(currentYear, 1, 8),
                LocalDate.of(currentYear, 2, 23),
                LocalDate.of(currentYear, 3, 8),
                LocalDate.of(currentYear, 4, 29),
                LocalDate.of(currentYear, 4, 30),
                LocalDate.of(currentYear, 5, 1),
                LocalDate.of(currentYear, 5, 9),
                LocalDate.of(currentYear, 5, 10),
                LocalDate.of(currentYear, 6, 12),
                LocalDate.of(currentYear, 11, 4),
                LocalDate.of(currentYear, 12, 30),
                LocalDate.of(currentYear, 12, 31));
    }

}
