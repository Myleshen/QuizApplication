package com.myleshen.quiz.security.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class AuthenticationResponseModel {

    private final String jwtToken;
    private Date jwtExpiration;

}
