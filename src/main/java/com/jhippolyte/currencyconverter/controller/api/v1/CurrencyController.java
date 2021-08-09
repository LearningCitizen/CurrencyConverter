package com.jhippolyte.currencyconverter.controller.api.v1;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/currenciesTrigrams")
	public ResponseEntity<List<String>> getAllCurrenciesTrigrams() {
		return ResponseEntity.ok(currencyService.getCurrenciesTrigramsList());
	}
	
	/*
	 * TODO change param
	 */
	@GetMapping("/currencyByTrigram")
	public ResponseEntity getCurrencyByTrigram(String currencyTrigram){
		ResponseEntity re = null;
		try {
			logger.info("Trying to get Currency by trigram");
			Currency curr = currencyService.getCurrencyByTrigram(currencyTrigram);
			re = ResponseEntity.ok(curr);
		} catch (CurrencyException e) {
			logger.error(e.getMessage());
			re = ResponseEntity.internalServerError().body(e);
		} finally {
			return re;
		}
	}
}
