package com.bastug.quiz.dtos.incoming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Long id;

    private String question;
    private String answer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String course;
}
