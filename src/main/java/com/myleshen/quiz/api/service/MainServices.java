package com.myleshen.quiz.api.service;


import com.myleshen.quiz.api.model.Answer;
import com.myleshen.quiz.api.model.Question;
import com.myleshen.quiz.api.repository.AnswerRepository;
import com.myleshen.quiz.api.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainServices {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public MainServices(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public String SaveQuestion(Question question){
        questionRepository.save(question);
        return "Success";
    }

    public String SaveAnswer(Answer answer){
        answer.setQuestion(answer.getQuestion());
        answerRepository.save(answer);
        return "Success";
    }

    public List<Question> GetQuestions() {
        return questionRepository.findAll();
    }

    public Optional<Question> GetQuestionById(Integer id){
        return questionRepository.findById(id);
    }

}
