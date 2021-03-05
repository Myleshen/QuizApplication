package com.myleshen.quiz.api.repository;

import com.myleshen.quiz.api.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
