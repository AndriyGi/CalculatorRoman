package com.company.exception;



public class NegativeResultException extends RuntimeException{

    public NegativeResultException(String message) {
        super(message);
    }

    public NegativeResultException() {
        this(" неверныое выражение тк" +
                "- в результате вычисления получено отрицательное значение," +
                "- в римской системе нет отрицательных чисел");
    }
}
