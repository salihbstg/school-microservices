package com.bastug.quiz.service;

import com.bastug.quiz.dtos.incoming.Course;
import com.bastug.quiz.dtos.incoming.Question;
import com.bastug.quiz.dtos.outgoing.QuizResponse;
import com.bastug.quiz.feign.CourseFeign;
import com.bastug.quiz.feign.QuestionFeign;
import com.bastug.quiz.model.Quiz;
import com.bastug.quiz.repository.QuizRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final CourseFeign courseFeign;
    private final QuestionFeign questionFeign;
    public QuizResponse getQuiz(String title,int questionCount, String courseName) {
        Course course=courseFeign.getCoursesByCourseName(courseName);
        if(course==null){
            return new QuizResponse();
        }

        List<Question> questions=questionFeign.getQuestionsForQuiz(questionCount,course.getCourseName());
        Quiz quiz=new Quiz();
        QuizResponse quizResponse=new QuizResponse();

        quizResponse.setId(quiz.getId());
        quizResponse.setTitle(title);
        quizResponse.setStartDate(quiz.getStartDate());
        quizResponse.setCourse(course.getCourseName());

        quiz.setTitle(title);
        quiz.setCourse(course.getCourseName());
        for(Question question:questions){
            quiz.getQuestionIds().add(question.getId());
            quizResponse.getQuestions().add(question);
        }
        quizRepository.save(quiz);
        return quizResponse;
    }
}
