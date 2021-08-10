package com.jhippolyte.currencyconverter.service;

import java.util.List;

import com.jhippolyte.currencyconverter.exception.CurrencyException;
import com.jhippolyte.currencyconverter.model.Currency;

/*
 * The interface Currency Service
 */
public interface CurrencyService {
	
	/*
	 * Get the list of currencies trigrams
	 * 
	 * @return the list of currencies trigrams managed
	 */
	public List<Currency> getCurrenciesList();
	
	/*
	 * Get the currency thanks to its trigram
	 * 
	 * @param currencyTrigram the trigram of a currency
	 * @return the currency associated to the trigram
	 */
	public Currency getCurrencyByTrigram(String currencyTrigram)throws CurrencyException;
	/*
	 * Convert an amount of money from a currency to another one
	 * 
	 * @param currencySource The currency source for the conversion
	 * @param currencyTarget The currency target for the conversion
	 * @param amount The amount of money to convert
	 * @return the money equivalent in the target currency
	 */
	public double convertCurrency (String currencySource, String currencyTarget, double amount) throws CurrencyException;
	
	
}
