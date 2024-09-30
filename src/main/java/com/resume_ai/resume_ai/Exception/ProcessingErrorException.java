package com.resume_ai.resume_ai.Exception;

public class ProcessingErrorException extends RuntimeException{
    public ProcessingErrorException(String errorMessage){
        super(errorMessage);
    }

}
