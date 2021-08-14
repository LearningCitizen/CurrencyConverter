package com.jhippolyte.currencyconverter.service;

import com.jhippolyte.currencyconverter.exception.CurrencyException;
import com.jhippolyte.currencyconverter.model.Currency;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyServiceImplTest {

    static Currency usdCurrency;
    static Currency eurCurrency;
    @Autowired
    CurrencyService currencyService;

    @BeforeAll
    static void init() {
        usdCurrency = new Currency("US Dollar", "USD", 1.0);
        eurCurrency = new Currency("Euro", "EUR", 0.85073);
    }

    @Test
    void getCurrenciesList() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation> violations = new HashSet<ConstraintViolation>();
        currencyService.getCurrenciesList().stream()
                .forEach(cur -> violations.addAll(validator.validate(cur)));
        assertTrue(violations.size() == 0);
    }

    @Test
    void should_get_valid_currency_by_trigram() throws CurrencyException {
        assertEquals(currencyService.getCurrencyByTrigram("USD"), usdCurrency);
    }

    @Test
    void should_throw_an_exception() {
        CurrencyException currencyException = assertThrows(CurrencyException.class, () -> currencyService.getCurrencyByTrigram("DRLF"));
        assertTrue(currencyException.getMessage().contains("does not exist"));
    }

    @Test
    void convertCurrency() throws CurrencyException {
        Double conversion = currencyService.convertCurrency("EUR", "USD", 1.0);
        DecimalFormat f = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        f.setMaximumFractionDigits(2);
        assertEquals(f.format(conversion), "1.18");
    }
}