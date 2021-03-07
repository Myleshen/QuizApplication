package com.myleshen.quiz.api.controller;


import com.myleshen.quiz.api.model.AnswerModel;
import com.myleshen.quiz.api.model.MaskedQuestionModel;
import com.myleshen.quiz.api.model.QuestionModel;
import com.myleshen.quiz.api.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")

public class QuestionAnswerController {

    private final QuestionAnswerService questionAnswerService;

    @Autowired
    private QuestionAnswerController(QuestionAnswerService questionAnswerService){
        this.questionAnswerService = questionAnswerService;
    }


    @GetMapping
    public String Index() {
        return "Index";
    }

    @PostMapping("save/question")
    public ResponseEntity<?> saveQuestion(@RequestBody QuestionModel questionModel) {
        List<AnswerModel> answerModelList = questionModel.getAnswerList();
        answerModelList.forEach(questionAnswerService::saveAnswer);
        return questionAnswerService.saveQuestion(questionModel);
    }

    @GetMapping("get/questions/masked")
    public List<MaskedQuestionModel> getMaskedQuestions() {
        return questionAnswerService.getMaskedQuestions();
    }

    @GetMapping("get/questions/nonmasked")
    public List<QuestionModel> getQuestions() {
        return questionAnswerService.getQuestions();
    }

    @GetMapping("get/question/{id}")
    public QuestionModel getQuestionById(@PathVariable Integer id){
        return questionAnswerService.getQuestionById(id).orElse(new QuestionModel());
    }

    @PostMapping("validate")
    public Boolean validateAnswer(@RequestBody Integer questionId, Integer answerNumber){
        return questionAnswerService.validateAnswerForQuestion(questionId, answerNumber);
    }

}
