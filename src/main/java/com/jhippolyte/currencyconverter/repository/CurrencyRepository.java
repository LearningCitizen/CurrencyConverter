package com.jhippolyte.currencyconverter.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jhippolyte.currencyconverter.model.Currency;

@Component
public class CurrencyRepository {

    private static List<Currency> currencies ; 
    
    static {
    	currencies = new ArrayList<Currency>();
    	currencies.add(new Currency("US Dollar", "USD", 1.0));
    	currencies.add(new Currency("Euro", "EUR", 0.85073));
    	currencies.add(new Currency("British Pound", "GBP", 0.72114));
    	currencies.add(new Currency("Indian Rupee", "INR", 74.292));
    	currencies.add(new Currency("Australian Dollar", "AUD", 1.3598));
    	currencies.add(new Currency("Canadian Dollar", "CAD", 1.2561));
    	currencies.add(new Currency("Singapore Dollar", "SGD", 1.3557));
    	currencies.add(new Currency("Swiss Franc", "CHF", 0.91820));
    }
    
    public List<Currency> findAllCurrencies() {
    	return currencies;
    }
    
    public Optional<Currency> findCurrencyByTrigram (String trigram) {
    	return Optional.of(currencies.stream().filter(cur -> cur.getTrigram().equals(trigram))
    			.findFirst().orElse(null));
    }
}