package com.example.university.service;


import com.example.university.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;



}
