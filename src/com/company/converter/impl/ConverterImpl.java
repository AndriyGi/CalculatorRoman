package com.company.converter.impl;

import com.company.converter.Converter;
import com.company.exception.IncorrectExpressionException;
import com.company.exception.NegativeResultException;

import java.util.Map;
import java.util.Optional;

import static com.company.constant.Constant.ROME_MAP_10;
import static com.company.constant.Constant.ROME_MAP_100;

public class ConverterImpl implements Converter {


    @Override
    public int convertRomanToNumbers(String romanNumber) {

        Optional<Integer> result = ROME_MAP_10.entrySet()
                .stream().filter(entry ->
                        romanNumber.equalsIgnoreCase(entry.getValue()))
                .map(Map.Entry::getKey).findFirst();

        return result.orElseThrow(() -> new IncorrectExpressionException());
    }

    @Override
    public String convertNumberToRoman100(int number) {

        if (number <= 0) {
            throw new NegativeResultException();
        }

        if(number <=10){
            return ROME_MAP_10.get(number);
        }

        int tail = number % 10;
        int core = number - tail;

        return ROME_MAP_100.get(core) + ROME_MAP_10.getOrDefault(tail, "");

        }
    }
