package com.bastug.question_service.service;

import com.bastug.question_service.dtos.incoming.Course;
import com.bastug.question_service.feign.CourseFeign;
import com.bastug.question_service.model.Question;
import com.bastug.question_service.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final CourseFeign courseFeign;

    public Question saveQuestion(Question question) {
        Course course = courseFeign.getCoursesByCourseName(question.getCourse());
        if (course != null) {
            return questionRepository.save(question);
        }
        return null;
    }

    public List<Question> findQuestionsForQuiz(int questionCount, String course) {
        return questionRepository.findQuestionsForQuiz(questionCount, course);
    }

    public Boolean deleteQuestion(Long questionId) {
        questionRepository.delete(questionRepository.findById(questionId).get());
        return true;
    }
}
