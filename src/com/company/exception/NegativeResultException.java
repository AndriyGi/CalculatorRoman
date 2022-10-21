package com.company.exception;

public class NegativeResultException extends RuntimeException{

    public NegativeResultException(String message) {
        super(message);
    }

    public NegativeResultException() {
        this("- в результате вычисления получено отрицательное значение");
    }
}
