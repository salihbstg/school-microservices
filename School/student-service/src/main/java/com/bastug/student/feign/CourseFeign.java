package com.bastug.student.feign;

import com.bastug.student.dtos.incoming.InComingCourse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("COURSE-SERVICE")
public interface CourseFeign {
    @GetMapping("/name/{courseName}")
    public InComingCourse getCoursesByCourseName(@PathVariable String courseName);
    @GetMapping("/{id}")
    public InComingCourse getCourse(@PathVariable long id);
}
