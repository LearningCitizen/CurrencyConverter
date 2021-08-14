package com.jhippolyte.currencyconverter.service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jhippolyte.currencyconverter.exception.CurrencyException;
import com.jhippolyte.currencyconverter.model.Currency;
import com.jhippolyte.currencyconverter.repository.CurrencyRepository;

@Component
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;
	
	private static Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);

	@Override
	public List<Currency> getCurrenciesList() {
		logger.info("Getting list of currencies");
		logger.info("currencyRepository : "+currencyRepository);
		logger.info("currencyRepository.findAllCurrencies() : "+currencyRepository.findAllCurrencies());
		return currencyRepository.findAllCurrencies();
	}
	
	public Currency getCurrencyByTrigram(String currencyTrigram) throws CurrencyException {
		logger.info("trying getting currency : "+currencyTrigram);
		Optional<Currency> currOpt = currencyRepository.findCurrencyByTrigram(currencyTrigram);
		if (!currOpt.isPresent())
			throw new CurrencyException("The Currency "+currOpt+" does not exist in our database");
		return currOpt.get();
	}

	@Override
	public double convertCurrency(String currencyTrigramSource, String currencyTrigramTarget, double amount) throws CurrencyException {
		logger.info("trying getting source currency");
		Currency currSource = getCurrencyByTrigram(currencyTrigramSource);
		logger.info("trying target currency");
		Currency currTarget = getCurrencyByTrigram(currencyTrigramTarget);
		logger.info("converting in the target currency");
		return (currTarget.getExchangeRate()*amount)/currSource.getExchangeRate();
	}

}
