package com.cg.apps.surveyapp.exceptions;

public class InvalidOptionException extends RuntimeException{

    public InvalidOptionException(){
    }

    public InvalidOptionException(String msg){
        super(msg);
    }

}
