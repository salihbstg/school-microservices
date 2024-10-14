package com.bastug.student.model;

import com.bastug.student.enums.FieldOfStudy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    @SequenceGenerator(name = "student_seq",sequenceName = "student_sequence",initialValue = 249811,allocationSize = 9319)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate registrationDate;

    @Enumerated(EnumType.STRING)
    private FieldOfStudy fieldOfStudy;

    private String username;
    private String password;

    @ElementCollection
    private Set<Long> coursesIds = new HashSet<>();
}
