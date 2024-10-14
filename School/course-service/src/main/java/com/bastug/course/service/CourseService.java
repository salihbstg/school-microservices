package com.bastug.course.service;

import com.bastug.course.model.Course;
import com.bastug.course.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Course createCours(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findByCourseName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }

    public Course findById(long id) {
        return courseRepository.findById(id).orElse(null);
    }
}
