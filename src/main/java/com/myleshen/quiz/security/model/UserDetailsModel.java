package com.myleshen.quiz.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserDetails")
public class UserDetailsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    private Boolean isActive;
    @JsonIgnore
    private Boolean isNonExpired;
    @JsonIgnore
    private Boolean isCredentialsNonExpired;
    @JsonIgnore
    private Boolean isAccountNonLocked;

    @Column(unique = true)
    private String userName;

    private String password;

    @JsonIgnore
    private String roles;

}
