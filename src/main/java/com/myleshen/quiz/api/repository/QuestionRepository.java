package com.myleshen.quiz.api.repository;

import com.myleshen.quiz.api.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
