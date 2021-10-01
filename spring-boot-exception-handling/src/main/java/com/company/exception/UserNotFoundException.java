package com.company.exception;

public class UserNotFoundException extends RuntimeException{

    private final static String MESSAGE = "User Not found ";

    public UserNotFoundException(){
        super(MESSAGE);
    }

}
