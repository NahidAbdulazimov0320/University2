package com.example.university.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;


@Getter
@AllArgsConstructor
public class ErrorResponse{

    private int statusCode;
    private String message;
    private LocalDateTime time;
}
