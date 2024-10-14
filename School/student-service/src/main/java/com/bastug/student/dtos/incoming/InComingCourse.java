package com.bastug.student.dtos.incoming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InComingCourse {
    private Long id;
    private String courseName;
    private int weeklyHours;
}
