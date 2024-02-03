package com.springboot.springsecurity.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/loan")
public class LoanController {

    @GetMapping("/my-loan")
    public String getMyLoans(){
        System.out.println("Return");
        return "Get loan details";
    }
}
