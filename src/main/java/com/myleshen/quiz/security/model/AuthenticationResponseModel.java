package com.myleshen.quiz.security.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthenticationResponseModel {

    private final String jwtToken;

}
