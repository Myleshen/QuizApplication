package com.myleshen.quiz.api.service;


import com.myleshen.quiz.api.model.AnswerModel;
import com.myleshen.quiz.api.model.MaskedQuestionModel;
import com.myleshen.quiz.api.model.QuestionModel;
import com.myleshen.quiz.api.repository.AnswersRepository;
import com.myleshen.quiz.api.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public ResponseEntity<?> saveQuestion(QuestionModel questionModel){
        questionsRepository.save(questionModel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public void  saveAnswer(AnswerModel answerModel){
        answersRepository.save(answerModel);
    }

    public List<QuestionModel> getQuestions(){
        return questionsRepository.findAll();
    }

    public List<MaskedQuestionModel> getMaskedQuestions() {
        List<QuestionModel> questions = questionsRepository.findAll();
        List<MaskedQuestionModel> maskedQuestions = new ArrayList<>();
        for (QuestionModel question : questions) {
            maskedQuestions.add(new MaskedQuestionModel(question));
        }
        return maskedQuestions;
    }

    public Optional<QuestionModel> getQuestionById(Integer id){
        return questionsRepository.findById(id);
    }

    public Boolean validateAnswerForQuestion(Integer questionId, Integer answerNumber) {
        QuestionModel question =
                questionsRepository.findById(questionId).orElse(null);
        Integer correctAnswer = question != null ? question.getCorrectAnswer() : -1;
        return answerNumber.equals(correctAnswer);
    }

}
