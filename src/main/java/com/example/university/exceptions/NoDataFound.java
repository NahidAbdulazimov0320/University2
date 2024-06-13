package com.example.university.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//TODO rename to non specific name
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDataFound extends RuntimeException {
}