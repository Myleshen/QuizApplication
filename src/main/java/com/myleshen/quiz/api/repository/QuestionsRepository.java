package com.myleshen.quiz.api.repository;

import com.myleshen.quiz.api.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<QuestionModel, Integer> {

}
