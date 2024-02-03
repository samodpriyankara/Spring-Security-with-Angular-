package com.springboot.springsecurity.controller;

import com.springboot.springsecurity.model.User;
import com.springboot.springsecurity.repository.UserRepo;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/login")
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        ResponseEntity responseEntity = null;
        try{
            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            user.setRole("ROLE_"+user.getRole());
            User user1 = userRepo.save(user);
            if(user1.getId()>0){
                responseEntity = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given users are successfully registered");
            }

        }catch (Exception e){
            responseEntity = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("An Excception occured due to "+e.getMessage());
        }
        return responseEntity;
    }
}
