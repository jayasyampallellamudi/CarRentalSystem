package com.javatrainingschool.exception;

public class CarException extends RuntimeException {
    public CarException(Integer id) {
        super("Car not found with ID: " + id);
    }
}
