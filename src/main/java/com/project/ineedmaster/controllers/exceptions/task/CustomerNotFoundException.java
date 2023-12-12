package com.project.ineedmaster.controllers.exceptions.task;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException (String message) {
        super("Customer with id " + message + " not found.");
    }
}
