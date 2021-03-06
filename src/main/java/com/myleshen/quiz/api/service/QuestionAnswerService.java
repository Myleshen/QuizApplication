package com.myleshen.quiz.api.service;


import com.myleshen.quiz.api.model.AnswerModel;
import com.myleshen.quiz.api.model.QuestionModel;
import com.myleshen.quiz.api.repository.AnswersRepository;
import com.myleshen.quiz.api.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionAnswerService {

    private final QuestionsRepository questionsRepository;
    private final AnswersRepository answersRepository;

    @Autowired
    public QuestionAnswerService(QuestionsRepository questionsRepository, AnswersRepository answersRepository) {
        this.questionsRepository = questionsRepository;
        this.answersRepository = answersRepository;
    }

    public String SaveQuestion(QuestionModel questionModel){
        questionsRepository.save(questionModel);
        return "Success";
    }

    public String SaveAnswer(AnswerModel answerModel){
        answersRepository.save(answerModel);
        return "Success";
    }

    public List<QuestionModel> GetQuestions() {
        return questionsRepository.findAll();
    }

    public Optional<QuestionModel> GetQuestionById(Integer id){
        return questionsRepository.findById(id);
    }

}
