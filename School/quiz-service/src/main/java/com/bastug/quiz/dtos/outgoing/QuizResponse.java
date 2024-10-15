package com.bastug.quiz.dtos.outgoing;

import com.bastug.quiz.dtos.incoming.Question;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizResponse {
    private Long id;

    private String title;
    private LocalDate startDate;

    private List<Question> questions = new ArrayList<>();

    private String course;

}
