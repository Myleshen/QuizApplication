package com.myleshen.quiz.security.repository;

import com.myleshen.quiz.security.model.UserDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetailsModel, Long> {

    Optional<UserDetailsModel> findByUserName(String userName);

}
