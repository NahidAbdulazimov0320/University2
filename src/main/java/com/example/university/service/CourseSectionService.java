package com.example.university.service;

import com.example.university.repository.CourseSectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class CourseSectionService {

    private final CourseSectionRepository courseSectionRepository;


}
