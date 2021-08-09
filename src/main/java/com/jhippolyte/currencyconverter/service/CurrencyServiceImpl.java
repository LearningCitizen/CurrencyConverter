package com.jhippolyte.currencyconverter.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jhippolyte.currencyconverter.exception.CurrencyException;
import com.jhippolyte.currencyconverter.model.Currency;
import com.jhippolyte.currencyconverter.repository.CurrencyRepository;

public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;
	
	private static Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);

	@Override
	public List<String> getCurrenciesList() {
		logger.info("Getting list of currencies");
		return currencyRepository.findAllCurrencies()
				.stream().map(cur -> cur.toString()).toList();
	}

	@Override
	public double convertCurrency(String currencySource, String currencyTarget, double amount) throws CurrencyException {
		logger.info("trying getting source currency and target currency");
		Optional<Currency> currSourceOpt = currencyRepository.findCurrencyByTrigram(currencySource);
		Optional<Currency> currTargetOpt = currencyRepository.findCurrencyByTrigram(currencyTarget);
		if (currSourceOpt.isEmpty())
			throw new CurrencyException("The Currency "+currencySource+" does not exist in our database");
		if (currTargetOpt.isEmpty())
			throw new CurrencyException("The Currency "+currencyTarget+" does not exist in our database");
		Currency currSource = currSourceOpt.get();
		Currency currTarget = currTargetOpt.get();
		logger.info("converting in the target currency");
		return (currSource.getExchangeRate()*amount)/currTarget.getExchangeRate();
	}
	
	

}
