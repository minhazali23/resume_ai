package com.resume_ai.resume_ai.Exception;

public class InvalidRegexMatchException extends RuntimeException{
    public InvalidRegexMatchException(String errorMessage){
        super(errorMessage);
    }
}
