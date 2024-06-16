package com.example.university.exceptions;


import lombok.*;


@Getter
@AllArgsConstructor
public class ErrorResponse{

    private int statusCode;
    private String message;

}
