package com.bastug.quiz.feign;

import com.bastug.quiz.dtos.incoming.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuestionFeign {
    @GetMapping
    List<Question> getQuestionsForQuiz(@RequestParam(name = "questionCount") int questionCount, @RequestParam(name = "course") String course);
}
