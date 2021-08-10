package com.jhippolyte.currencyconverter.controller.v1.api;

import java.util.List;

import com.jhippolyte.currencyconverter.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhippolyte.currencyconverter.exception.CurrencyException;
import com.jhippolyte.currencyconverter.model.Currency;
import com.jhippolyte.currencyconverter.service.CurrencyService;

@RestController
@RequestMapping("/api/v1")
public class CurrencyController {

    private Logger logger = LoggerFactory.getLogger(CurrencyController.class);

    @Autowired
    CurrencyService currencyService;

    /*
     * Get all the trigrams of currencies
     *
     */
    @GetMapping("/currenciesTrigrams")
    public ResponseEntity<String> getAllCurrenciesTrigrams() {
        return ResponseEntity.ok(JsonUtils.toJson(currencyService.getCurrenciesTrigramsList()));
    }

    /*
     * Get the currency associated to the given trigram.
     *
     * @param trigram A trigram associated to a currency.
     */
    @GetMapping("/currencyByTrigram")
    public ResponseEntity getCurrencyByTrigram(@RequestParam String trigram) {
        ResponseEntity re = null;
        try {
            logger.info("Trying to get Currency by trigram");
            Currency curr = currencyService.getCurrencyByTrigram(trigram);
            re = ResponseEntity.ok(JsonUtils.toJson(curr));
        } catch (CurrencyException e) {
            logger.error(e.getMessage());
            re = ResponseEntity.internalServerError().body(e);
        } finally {
            return re;
        }
    }
}
