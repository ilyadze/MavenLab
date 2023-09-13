package com.example.exception;


public class InvalidCarException extends RuntimeException {
    public InvalidCarException(String msg) {
        super(msg);
    }
}