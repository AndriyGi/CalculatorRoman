package com.company.exception;

public class NotFoundMathOperatorException extends RuntimeException{

    public NotFoundMathOperatorException(String message) {
        super(message);
    }

    public NotFoundMathOperatorException() {
        this("- в введенной строке отсутствует математический оператор");
    }
}

