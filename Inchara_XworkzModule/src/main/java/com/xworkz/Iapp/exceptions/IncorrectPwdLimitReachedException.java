package com.xworkz.Iapp.exceptions;

public class IncorrectPwdLimitReachedException extends RuntimeException {
    public IncorrectPwdLimitReachedException(String message) {
        super(message);
    }
}
