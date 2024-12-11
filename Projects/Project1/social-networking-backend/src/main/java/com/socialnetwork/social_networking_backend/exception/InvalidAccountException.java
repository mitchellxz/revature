package com.socialnetwork.social_networking_backend.exception;

public class InvalidAccountException extends RuntimeException{
    public InvalidAccountException(String message) {
        super(message);
    }
}
