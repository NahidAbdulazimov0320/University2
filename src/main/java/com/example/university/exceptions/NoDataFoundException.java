package com.example.university.exceptions;

import lombok.Getter;

@Getter
public class NoDataFoundException extends RuntimeException{
    private String message;

    public NoDataFoundException(String message){
        super(message);
        this.message = message;
    }


}