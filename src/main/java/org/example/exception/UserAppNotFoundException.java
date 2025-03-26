package org.example.exception;

public class UserAppNotFoundException extends RuntimeException{

    public UserAppNotFoundException(String message) {
        super(message);
    }
}
