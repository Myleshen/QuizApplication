package com.myleshen.quiz.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    private Integer id;
    private String answerText;
    private Boolean isCorrectAnswer;

    @ManyToOne
    private Question question;


}
