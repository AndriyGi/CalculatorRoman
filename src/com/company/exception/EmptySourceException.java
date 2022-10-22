package com.company.exception;



public class EmptySourceException extends RuntimeException {

    public EmptySourceException() {
        this("Пустая строка введена");
    }

    public EmptySourceException(String message) {
        super(message);
    }

}
