package com.beransantur.flightticketsapp.utils.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super("Entity was not found. " + message);
    }
}
