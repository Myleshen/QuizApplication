package com.myleshen.quiz.api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Questions")
public class QuestionModel {

    @Id
    private Integer id;

    private String questionText;
    private Integer correctAnswer;

    @OneToMany
    @JsonAlias(value = "answerList")
    private List<AnswerModel> answerList;

}
