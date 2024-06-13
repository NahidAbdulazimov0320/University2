package com.example.university.controller;

import java.util.List;

public interface BasicControllerMethods< R, T> {
    List<R> getAll();
    R getById(T id);

    R create(R dto);

    R updateById(T id, R dto);

    void deleteById(T id);

}
