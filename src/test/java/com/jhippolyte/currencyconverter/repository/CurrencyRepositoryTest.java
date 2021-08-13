package com.jhippolyte.currencyconverter.repository;

import com.jhippolyte.currencyconverter.model.Currency;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyRepositoryTest {

    @Autowired
    CurrencyRepository currencyRepository;
    static Currency usdCurrency;

    @BeforeAll
    static void init() {
        usdCurrency = new Currency("US Dollar", "USD", 1.0);
    }

    @Test
    void should_findAllCurrencies() {
        assertTrue(currencyRepository.findAllCurrencies().size()>0);
    }

    @Test
    void all_curencies_should_be_valid(){
        Set<ConstraintViolation> violations = new HashSet<ConstraintViolation>();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        currencyRepository.findAllCurrencies().stream()
                .forEach(cur -> violations.addAll(validator.validate(cur)));
        assertTrue(violations.size() == 0);
    }

    @Test
    void findCurrencyByTrigram() {
        assertEquals(usdCurrency, currencyRepository.findCurrencyByTrigram("USD").get());
    }
}