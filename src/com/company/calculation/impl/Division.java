package com.company.calculation.impl;

import com.company.calculation.Calculation;

public class Division implements Calculation {

    @Override
    public int calculate(int a, int b) {
        return a / b;
    }
}
