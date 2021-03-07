package com.myleshen.quiz.security.controller;

import com.myleshen.quiz.security.jwt.JwtUtility;
import com.myleshen.quiz.security.model.AuthenticationRequestModel;
import com.myleshen.quiz.security.model.AuthenticationResponseModel;
import com.myleshen.quiz.security.model.UserDetailsModel;
import com.myleshen.quiz.security.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SecurityController {


    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserDetailService userDetailService;
    private final JwtUtility jwtUtility;

    @Autowired
    public SecurityController(AuthenticationManager authenticationManager,
                              BCryptPasswordEncoder passwordEncoder,
                              UserDetailService userDetailService,
                              JwtUtility jwtUtility) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userDetailService = userDetailService;
        this.jwtUtility = jwtUtility;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody AuthenticationRequestModel authenticationRequestModel
    ) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequestModel.getUserName(),
                    authenticationRequestModel.getPassword()
            ));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username Or Password....");
        }
        final UserDetails userDetails = userDetailService
                .loadUserByUsername(authenticationRequestModel.getUserName());

        final String jwt = jwtUtility.generateToken(userDetails);
        Date jwtExpirationDate = jwtUtility.extractExpiration(jwt);

        return ResponseEntity.ok(new AuthenticationResponseModel(jwt, jwtExpirationDate));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody UserDetailsModel userDetails){
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        userDetails.setIsActive(true);
        userDetails.setIsNonExpired(true);
        userDetails.setIsCredentialsNonExpired(true);
        userDetails.setIsAccountNonLocked(true);
        userDetails.setRoles("USER");
        return userDetailService.createUser(userDetails);
    }

    @PostMapping("/signup/admin")
    public ResponseEntity<?> saveAdminUser(@RequestBody UserDetailsModel userDetails) {
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        userDetails.setIsActive(true);
        userDetails.setIsNonExpired(true);
        userDetails.setIsCredentialsNonExpired(true);
        userDetails.setIsAccountNonLocked(true);
        userDetails.setRoles("USER, ADMIN");
        return userDetailService.createUser(userDetails);
    }
}
