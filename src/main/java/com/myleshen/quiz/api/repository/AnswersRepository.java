package com.myleshen.quiz.api.repository;

import com.myleshen.quiz.api.model.AnswerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswersRepository extends JpaRepository<AnswerModel, Integer> {
}
