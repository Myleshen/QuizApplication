package com.myleshen.quiz.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Answers")
public class AnswerModel {

    @Id
    private Integer id;
    private String answerText;
    private Boolean isCorrectAnswer;

    @ManyToOne
    private QuestionModel question;


}
