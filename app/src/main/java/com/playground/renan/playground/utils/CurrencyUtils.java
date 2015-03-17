package com.playground.renan.playground.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Created by renan on 2/10/15.
 */
public class CurrencyUtils {

    public static String format(BigDecimal value){
        return NumberFormat.getCurrencyInstance().format(value);
    }
}
