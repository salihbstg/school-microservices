package com.bastug.student.controller;

import com.bastug.student.dtos.incoming.CreateStudentDto;
import com.bastug.student.dtos.outgoing.StudentResponseDto;
import com.bastug.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    //Create student
    @PostMapping
    public ResponseEntity<CreateStudentDto> createStudent(@RequestBody CreateStudentDto createStudentDto) {
        return new ResponseEntity<>(studentService.saveStudent(createStudentDto), HttpStatus.CREATED);
    }

    //Add course
    @PostMapping("{studentId}/courses/add")
    public ResponseEntity<StudentResponseDto> addCourse(@PathVariable(name = "studentId") Long id,@RequestParam(name = "courseName") String courseName) {
        return new ResponseEntity<>(studentService.addCourse(id,courseName),HttpStatus.CREATED);
    }


    //Find student by ıd
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudent(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }


    // Find by username
    @GetMapping("/username/{username}")
    public ResponseEntity<StudentResponseDto> getStudentsByUsername(@PathVariable(name = "username") String username) {
        return ResponseEntity.ok(studentService.findByUsername(username));
    }


    // Find all
    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }
}
