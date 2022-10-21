package com.company.exception;

public class IncorrectExpressionException extends RuntimeException{

    public IncorrectExpressionException() {
        this ("- введено некорректное выражение");
    }

    public IncorrectExpressionException(String message) {
        super(message);
    }
}
