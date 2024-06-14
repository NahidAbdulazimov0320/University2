package com.example.university.exceptions;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.Supplier;

@Getter
@Setter
public class NoSuchEntityFoundException extends RuntimeException{
    private String message;

    public NoSuchEntityFoundException(){}
    public NoSuchEntityFoundException(String message){
        super(message);
        this.message = message;
    }


}