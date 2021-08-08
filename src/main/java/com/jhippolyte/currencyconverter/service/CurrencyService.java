package com.jhippolyte.currencyconverter.service;

import java.util.List;

/*
 * The interface Currency Service
 */
public interface CurrencyService {
	
	/*
	 * Get the list of currencies
	 * 
	 * @return the list of currencies managed
	 */
	public List<String> getCurrenciesList ();
	
	/*
	 * Convert an amount of money from a currency to another one
	 * 
	 * @param currencySource The currency source for the conversion
	 * @param currencyTarget The currency target for the conversion
	 * @param amount The amount of money to convert
	 * @return the money equivalent in the target currency
	 */
	public double convertCurrency (String currencySource, String currencyTarget, double amount);
	
	
}
