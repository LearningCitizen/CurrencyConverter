package com.jhippolyte.currencyconverter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.*;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Currency {

    @NotEmpty
    String name;

    @Size(min = 3, max = 3, message = "The trigram should becomposed of 3 characters")
    String trigram;

    @Positive
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        return trigram != null ? trigram.equals(currency.trigram) : currency.trigram == null;
    }

    @Override
    public int hashCode() {
        return trigram != null ? trigram.hashCode() : 0;
    }
}
