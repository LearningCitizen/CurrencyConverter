package com.jhippolyte.currencyconverter.controller.v1.api;

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
@RequestMapping("/api/v1/currencies")
public class CurrencyController {

    private Logger logger = LoggerFactory.getLogger(CurrencyController.class);

    @Autowired
    CurrencyService currencyService;

    /*
     * Get all the trigrams of currencies
     *
     */
    @GetMapping
    public ResponseEntity<String> getAllCurrencies() {
        return ResponseEntity.ok(JsonUtils.toJson(currencyService.getCurrenciesList()));
    }

    /*
     * Get the currency associated to the given trigram.
     *
     * @param trigram A trigram associated to a currency.
     */
    @GetMapping("/currency")
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

    /*
     * Get the currency associated to the given trigram.
     *
     * @param trigram A trigram associated to a currency.
     */
    @GetMapping("/conversion")
    public ResponseEntity getCurrencyByTrigram(@RequestParam String source, @RequestParam String target, @RequestParam Double amount) {
        ResponseEntity re = null;
        try {
            logger.info("Trying to convert the amount into the target currency");
            Double conversion = currencyService.convertCurrency(source, target, amount);
            re = ResponseEntity.ok(JsonUtils.toJson(conversion));
        } catch (CurrencyException e) {
            logger.error(e.getMessage());
            re = ResponseEntity.internalServerError().body(e);
        } finally {
            return re;
        }
    }
}
