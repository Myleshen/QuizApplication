package com.myleshen.quiz.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question {

    @Id
    private Integer id;

    private String questionText;
    private Integer correctAnswer;

    @OneToMany
    private List<Answer> answerList;

}
