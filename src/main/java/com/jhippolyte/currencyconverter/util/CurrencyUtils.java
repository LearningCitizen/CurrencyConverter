package com.jhippolyte.currencyconverter.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyUtils {

    public static double round(double value, int scale) {
        if (scale > 0) {
            BigDecimal b = new BigDecimal(Double.toString(value));
            b = b.setScale(scale, RoundingMode.HALF_UP);
            return b.doubleValue();
        }
        return value;
    }
}
