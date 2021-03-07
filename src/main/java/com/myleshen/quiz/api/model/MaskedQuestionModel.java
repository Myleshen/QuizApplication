package com.myleshen.quiz.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaskedQuestionModel {

    private Integer id;
    private String questionText;
    private List<AnswerModel> answerList;


    public MaskedQuestionModel (QuestionModel question) {
        this.id = question.getId();
        this.questionText = question.getQuestionText();
        this.answerList = question.getAnswerList();
    }

}
