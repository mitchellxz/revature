package com.socialnetwork.social_networking_backend.exception;

public class UsernameExistsException extends RuntimeException{
    public UsernameExistsException(String message) {
        super(message);
    }
}
