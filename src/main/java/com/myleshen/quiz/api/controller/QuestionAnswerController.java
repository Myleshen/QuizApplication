package com.myleshen.quiz.api.controller;


import com.myleshen.quiz.api.model.AnswerModel;
import com.myleshen.quiz.api.model.QuestionModel;
import com.myleshen.quiz.api.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("save")
    public String save(@RequestBody QuestionModel questionModel) {
        System.out.println(questionModel.toString());
        List<AnswerModel> answerModelList = questionModel.getAnswerList();
        answerModelList.forEach(questionAnswerService::SaveAnswer);
        return questionAnswerService.SaveQuestion(questionModel);
    }

    @GetMapping("getquestions")
    public List<QuestionModel> getQuestions() {
        return questionAnswerService.GetQuestions();
    }

    @GetMapping("getquestion/{id}")
    public QuestionModel getQuestionById(@PathVariable Integer id){
        return questionAnswerService.GetQuestionById(id).orElse(new QuestionModel());
    }

}
