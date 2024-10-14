package com.bastug.course.repository;


import com.bastug.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByCourseName(String courseName);
}
