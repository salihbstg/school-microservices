package com.bastug.question_service.controller;

import com.bastug.question_service.model.Question;
import com.bastug.question_service.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.saveQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Question>> getQuestionsForQuiz(@RequestParam(name = "questionCount") int questionCount, @RequestParam(name = "course") String course) {
        return new ResponseEntity<>(questionService.findQuestionsForQuiz(questionCount,course),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteQuestion(@RequestParam(name = "questionId") Long questionId) {
        return new ResponseEntity<>(questionService.deleteQuestion(questionId),HttpStatus.OK);
    }
}
