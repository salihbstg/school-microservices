package com.bastug.course.controller;

import com.bastug.course.model.Course;
import com.bastug.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.createCours(course), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/name/{courseName}")
    public ResponseEntity<Course> getCoursesByCourseName(@PathVariable String courseName) {
        return ResponseEntity.ok(courseService.findByCourseName(courseName));
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.findAll());
    }

}
