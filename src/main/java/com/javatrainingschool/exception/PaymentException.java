package com.javatrainingschool.exception;

public class PaymentException extends RuntimeException{
    public PaymentException(Integer id) {
        super("Payment not found with ID: " + id);
    }
}
