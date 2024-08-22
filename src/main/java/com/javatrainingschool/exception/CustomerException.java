package com.javatrainingschool.exception;

public class CustomerException extends RuntimeException{
    public CustomerException(Integer id) {
        super("Customer not found with ID: " + id);
    }
}
