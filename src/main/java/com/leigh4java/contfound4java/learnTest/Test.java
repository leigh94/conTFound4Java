package com.leigh4java.contfound4java.learnTest;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        System.out.println(NumberFormatValidator.validateDecimalFormat("99999999999999999999999.99"));
        System.out.println(NumberFormatValidator.validateDecimalFormat("9999999A9999999999999.99"));
        System.out.println(NumberFormatValidator.validateDecimalFormat("999999999999999.99"));
        System.out.println(NumberFormatValidator.validateDecimalFormat("-99999999999999999999.99"));
}

}