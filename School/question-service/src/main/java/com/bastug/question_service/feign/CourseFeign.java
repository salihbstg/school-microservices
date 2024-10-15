package com.bastug.question_service.feign;

import com.bastug.question_service.dtos.incoming.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("COURSE-SERVICE")
public interface CourseFeign {
    @GetMapping("/name/{courseName}")
    Course getCoursesByCourseName(@PathVariable String courseName);

}
