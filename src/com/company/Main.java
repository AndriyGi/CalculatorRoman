package com.company;

import com.company.converter.Converter;
import com.company.converter.impl.ConverterImpl;
import com.company.validator.impl.ExpressionValidatorImpl;
import com.sun.deploy.net.MessageHeader;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] input) {

        new Calculator(new ExpressionValidatorImpl(), new ConverterImpl()).result();
    }
}
