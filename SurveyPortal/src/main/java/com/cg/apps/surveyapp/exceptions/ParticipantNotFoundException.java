package com.cg.apps.surveyapp.exceptions;

public class ParticipantNotFoundException extends RuntimeException{

    public ParticipantNotFoundException(){

    }

    public ParticipantNotFoundException(String msg){
        super(msg);
    }
}
