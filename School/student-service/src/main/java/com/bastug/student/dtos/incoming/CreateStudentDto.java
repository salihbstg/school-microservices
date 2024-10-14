package com.bastug.student.dtos.incoming;

import com.bastug.student.enums.FieldOfStudy;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateStudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate registrationDate=LocalDate.now();
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private FieldOfStudy fieldOfStudy;
}
