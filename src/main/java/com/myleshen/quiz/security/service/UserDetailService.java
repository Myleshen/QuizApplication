package com.myleshen.quiz.security.service;

import com.myleshen.quiz.security.model.UserDetailsModel;
import com.myleshen.quiz.security.repository.UserRepository;
import com.myleshen.quiz.security.utility.ConvertUserDetailModelToUserDetailsUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Autowired
    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetailsModel> user = userRepository.findByUserName(username);

        if (user.isPresent()) {
            return new ConvertUserDetailModelToUserDetailsUtility(user.get());
        }
        throw new UsernameNotFoundException("Recheck The Details");
    }

    public ResponseEntity<?> createUser(UserDetailsModel user){
        try {
            userRepository.save(user);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
