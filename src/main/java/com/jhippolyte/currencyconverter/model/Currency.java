package com.jhippolyte.currencyconverter.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Currency {

	String name;
	
	String trigram;
	
	Double exchangeRate;

	public Currency(String name, String trigram, Double exchangeRate) {
		super();
		this.name = name;
		this.trigram = trigram;
		this.exchangeRate = exchangeRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrigram() {
		return trigram;
	}

	public void setTrigram(String trigram) {
		this.trigram = trigram;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	//@Override
	//public String toString() {
	//	return "Currency [name=" + name + ", trigram=" + trigram + "]";
	//}
	
	
}
