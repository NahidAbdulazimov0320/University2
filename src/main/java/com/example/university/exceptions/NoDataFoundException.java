package com.example.university.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoDataFoundException extends RuntimeException{
    private String message;

    public NoDataFoundException(){}
    public NoDataFoundException(String message){
        super(message);
        this.message = message;
    }


}