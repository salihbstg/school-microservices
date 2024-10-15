package com.bastug.question_service.repository;

import com.bastug.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = "select * from question where course= :course ORDER BY RANDOM() LIMIT :questionCount",nativeQuery = true)
    List<Question> findQuestionsForQuiz(@Param("questionCount") int questionCount,@Param("course") String course);
}
