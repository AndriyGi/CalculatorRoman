package com.company;

import com.company.calculation.Calculation;
import com.company.calculation.impl.Addition;
import com.company.calculation.impl.Division;
import com.company.calculation.impl.Multiplication;
import com.company.calculation.impl.Subtraction;
import com.company.converter.Converter;
import com.company.exception.EmptySourceException;
import com.company.exception.IncorrectExpressionException;
import com.company.exception.NotFoundMathOperatorException;
import com.company.utils.NumUtil;
import com.company.validator.ExpressionValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import static com.company.constant.Constant.ROME_MAP_10;

public class Calculator {

    private final ExpressionValidator validator;
    private final Converter converter;

    public Calculator(ExpressionValidator validator, Converter converter) {
        this.validator = validator;
        this.converter = converter;
    }

    public void result() {

        System.out.println("Ввведите математическое выражение");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = null;

        try {
            inputLine = reader.readLine();
        } catch (IOException exception) {
            System.out.println("ОШИБКА!" + exception.getCause());
        }

        if (inputLine.isEmpty()) {
            throw new EmptySourceException();
        }

        String mathOperator = inputLine.replaceAll("[0-9a-zA-Zа-яА-Я]"
                , "");

        if (mathOperator.length() != 1) {
            throw new IncorrectExpressionException();
        }

        String[] arrInput = inputLine.split(mathOperator.contains("*")
                ? "\\*" : mathOperator.contains("+")
                ? "\\+" : mathOperator);

        validator.validate(arrInput);

        boolean isRomanExpression = NumUtil.isRomeNumber("" + inputLine.charAt(0));
        int result;

        switch (mathOperator) {
            case "*":
                Calculation calculation = new Multiplication();
                result = calculation.calculate(getNumber(arrInput[0]), getNumber(arrInput[1]));
                break;

            case "/":
                calculation = new Division();
                result = calculation.calculate(getNumber(arrInput[0]), getNumber(arrInput[1]));
                break;

            case "-":
                calculation = new Subtraction();
                result = calculation.calculate(getNumber(arrInput[0]), getNumber(arrInput[1]));
                break;

            case "+":
                calculation = new Addition();
                result = calculation.calculate(getNumber(arrInput[0]), getNumber(arrInput[1]));
                break;

            default:
                throw new NotFoundMathOperatorException();
        }

        System.out.println("result: " + (isRomanExpression
                ? converter.convertNumberToRoman100(result)
                : result));
    }


    private int getNumber(String source) {
        if (NumUtil.isArabianNumber(source)) {
            int number = Integer.parseInt(source);
            if (number == 0) {
                throw new IncorrectExpressionException("Ноль вводить нельзя");
            } else if (number > 10) {
                throw new IncorrectExpressionException("Нельзя вводить число больше 10");
            }
            return number;
        } else if (NumUtil.isRomeNumber(source)) {
            return converter.convertRomanToNumbers(source);
        }

        throw new IncorrectExpressionException("Выражение введено неверно");

    }


}
