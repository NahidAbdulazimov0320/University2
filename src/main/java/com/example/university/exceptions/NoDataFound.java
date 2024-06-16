package com.example.university.exceptions;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDataFound extends RuntimeException {

    public NoDataFound(){
        super();
    }
    public NoDataFound(String message){
        super(message);
    }
    public NoDataFound(String message, Throwable cause){
        super(message, cause);
    }
}