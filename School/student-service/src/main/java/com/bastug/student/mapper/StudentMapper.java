package com.bastug.student.mapper;

import com.bastug.student.dtos.incoming.CreateStudentDto;
import com.bastug.student.dtos.incoming.InComingCourse;
import com.bastug.student.dtos.outgoing.StudentResponseDto;
import com.bastug.student.feign.CourseFeign;
import com.bastug.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final CourseFeign courseFeign;

    public Student createStudentDtoToStudent(CreateStudentDto createStudentDto) {
        Student student = new Student();
        student.setFirstName(createStudentDto.getFirstName());
        student.setLastName(createStudentDto.getLastName());
        student.setEmail(createStudentDto.getEmail());
        student.setAddress(createStudentDto.getAddress());
        student.setRegistrationDate(createStudentDto.getRegistrationDate());
        student.setPhone(createStudentDto.getPhone());
        student.setFieldOfStudy(createStudentDto.getFieldOfStudy());
        student.setUsername(createStudentDto.getUsername());
        student.setPassword(createStudentDto.getPassword());
        return student;
    }

    public StudentResponseDto studentToStudentResponseDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setFirstName(student.getFirstName());
        studentResponseDto.setLastName(student.getLastName());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setAddress(student.getAddress());
        studentResponseDto.setRegistrationDate(student.getRegistrationDate());
        studentResponseDto.setPhone(student.getPhone());
        studentResponseDto.setFieldOfStudy(student.getFieldOfStudy().getFieldOfStudyResponse());
        studentResponseDto.setUsername(student.getUsername());
        studentResponseDto.setId(student.getId());
        for(Long id:student.getCoursesIds()){
            InComingCourse inComingCourse=courseFeign.getCourse(id);
            studentResponseDto.getCourses().add(inComingCourse.getCourseName());
        }
        return studentResponseDto;
    }
}
