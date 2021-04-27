package com.cg.apps.surveyapp.exceptions;

public class TopicNotFoundException extends RuntimeException{

    public TopicNotFoundException(){

    }

    public TopicNotFoundException(String msg){
        super(msg);
    }
}
