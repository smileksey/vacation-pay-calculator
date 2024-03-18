package com.smileksey.vacationpaycalculator.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentCalculationServiceTest {

    private PaymentCalculationService paymentCalculationService;
    private static final int CURRENT_YEAR = LocalDate.now().getYear();

    private static final BigDecimal TEST_AVERAGE_SALARY = new BigDecimal("30000.00");
    private static final int TEST_VACATION_DAYS = 14;

    @BeforeEach
    void setUp() {
        paymentCalculationService = new PaymentCalculationServiceImpl();
    }

    @AfterEach
    void tearDown() {
        paymentCalculationService = null;
    }

    @Test
    void getVacationPayment() {
        BigDecimal actualPayment = paymentCalculationService.getVacationPayment(TEST_AVERAGE_SALARY, TEST_VACATION_DAYS).getPaymentValue();
        assertEquals(0, actualPayment.compareTo(new BigDecimal("14334.46")));
    }

    @Test
    void getAmountOfPaidDaysShouldReturn13() {
        int actualPaidDays = paymentCalculationService.getAmountOfPaidDays(LocalDate.of(CURRENT_YEAR, 3, 4), 14);
        assertEquals(13, actualPaidDays);
    }
}