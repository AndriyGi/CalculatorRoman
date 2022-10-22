package com.company;

import com.company.converter.impl.ConverterImpl;
import com.company.validator.impl.ExpressionValidatorImpl;



public class Main {

    public static void main(String[] input) {

        new Calculator(new ExpressionValidatorImpl(), new ConverterImpl()).result();
    }
}
