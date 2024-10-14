package com.bastug.student.service;

import com.bastug.student.dtos.incoming.CreateStudentDto;
import com.bastug.student.dtos.incoming.InComingCourse;
import com.bastug.student.dtos.outgoing.StudentResponseDto;
import com.bastug.student.feign.CourseFeign;
import com.bastug.student.mapper.StudentMapper;
import com.bastug.student.model.Student;
import com.bastug.student.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final CourseFeign courseFeign;

    public CreateStudentDto saveStudent(CreateStudentDto createStudentDto) {
        studentRepository.save(studentMapper.createStudentDtoToStudent(createStudentDto));
        return createStudentDto;
    }

    public StudentResponseDto findById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentMapper.studentToStudentResponseDto(studentOptional.orElse(new Student()));
    }

    public List<StudentResponseDto> findAll() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentResponseDto> studentResponseDtoList = new ArrayList<>();
        for(Student student : studentList) {
            studentResponseDtoList.add(studentMapper.studentToStudentResponseDto(student));
        }
        return studentResponseDtoList;
    }

    public StudentResponseDto findByUsername(String username) {
        return studentMapper.studentToStudentResponseDto(studentRepository.findByUsername(username));
    }

    public StudentResponseDto addCourse(Long id, String courseName) {
        InComingCourse inComingCourse=courseFeign.getCoursesByCourseName(courseName);
        Student student=studentRepository.findById(id).orElse(new Student());
        student.getCoursesIds().add(inComingCourse.getId());
        studentRepository.save(student);
        return studentMapper.studentToStudentResponseDto(student);
    }
}
