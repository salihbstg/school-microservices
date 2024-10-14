package com.bastug.student.dtos.outgoing;

import com.bastug.student.enums.FieldOfStudy;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponseDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String username;
    private LocalDate registrationDate;

    private String fieldOfStudy;


    private Set<String> courses = new HashSet<>();
}
