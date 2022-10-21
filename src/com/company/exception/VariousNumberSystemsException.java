package com.company.exception;

public class VariousNumberSystemsException extends RuntimeException{

    public VariousNumberSystemsException(String message) {
        super(message);
    }

    public VariousNumberSystemsException() {
        this("- введены числа, принадлежащие разным системам счисления");
    }
}
