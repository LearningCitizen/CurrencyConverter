package com.jhippolyte.currencyconverter.util;

import com.jhippolyte.currencyconverter.model.Currency;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonUtilsTest {

    static Currency currency;
    static String jsonCurrency;

    @BeforeAll
    static void init() {
        currency = new Currency("Currency", "CUR", 1.0);
        jsonCurrency = "{\"name\":\"Currency\",\"trigram\":\"CUR\",\"exchangeRate\":1.0}";
    }
    @Test
    void should_create_valid_Json() {
        assertEquals(jsonCurrency, JsonUtils.toJson(currency));
    }
}