package com.jhippolyte.currencyconverter.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.jhippolyte.currencyconverter.exception.CurrencyException;
import com.jhippolyte.currencyconverter.model.Currency;
import com.jhippolyte.currencyconverter.repository.CurrencyRepository;

public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;

	@Override
	public List<String> getCurrenciesList() {
		return currencyRepository.findAllCurrencies()
				.stream().map(cur -> cur.toString()).toList();
	}

	@Override
	public double convertCurrency(String currencySource, String currencyTarget, double amount) throws CurrencyException {
		Optional<Currency> currSourceOpt = currencyRepository.findCurrencyByTrigram(currencySource);
		Optional<Currency> currTargetOpt = currencyRepository.findCurrencyByTrigram(currencyTarget);
		if (currSourceOpt.isEmpty())
			throw new CurrencyException("The Currency "+currencySource+" does not exist in our database");
		if (currTargetOpt.isEmpty())
			throw new CurrencyException("The Currency "+currencyTarget+" does not exist in our database");
		Currency currSource = currSourceOpt.get();
		Currency currTarget = currTargetOpt.get();

		return (currSource.getExchangeRate()*amount)/currTarget.getExchangeRate();
	}
	
	

}
