package com.myleshen.quiz.api.controller;


import com.myleshen.quiz.api.model.Answer;
import com.myleshen.quiz.api.model.Question;
import com.myleshen.quiz.api.service.MainServices;
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

public class MainController {

    private final  MainServices mainServices;

    @Autowired
    private MainController(MainServices mainServices){
        this.mainServices=mainServices;
    }


    @GetMapping
    public String Index() {
        return "Index";
    }

    @PostMapping("save")
    public String Save(@RequestBody Question question) {
        System.out.println(question.toString());
        List<Answer> answerList = question.getAnswerList();
        answerList.forEach(mainServices::SaveAnswer);
        return mainServices.SaveQuestion(question);
    }

    @GetMapping("getquestions")
    public List<Question> GetQuestions() {
        return mainServices.GetQuestions();
    }

    @GetMapping("getquestion/{id}")
    public Question GetQuestionById(@PathVariable Integer id){
        return mainServices.GetQuestionById(id).orElse(new Question());
    }

}
