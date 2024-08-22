package com.javatrainingschool.exception;

public class LeaseException extends RuntimeException{
    public LeaseException(Integer id) {
        super("Lease not found with ID: " + id);
    }
}
