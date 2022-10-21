package com.company.exception;

public class DivisionByZeroException extends RuntimeException {

    public DivisionByZeroException(String message) {
        super(message);
    }

    public DivisionByZeroException() {
        this("Деление на ноль невозможно");
    }

}
