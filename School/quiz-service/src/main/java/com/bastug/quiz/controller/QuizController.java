package com.bastug.quiz.controller;

import com.bastug.quiz.dtos.outgoing.QuizResponse;
import com.bastug.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @GetMapping
    public ResponseEntity<QuizResponse> getQuiz(@RequestParam(name = "title") String title,@RequestParam(name = "questionCount") int questionCount,@RequestParam(name = "courseName") String courseName) {
        return new ResponseEntity<>(quizService.getQuiz(title,questionCount,courseName), HttpStatus.OK);
    }
}
