package com.springboot.springsecurity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/notice")
public class AccountController {

    @GetMapping("/my-notice")
    public String getAccountDetails(){
        System.out.println("Return");
        return "Get notice details";
    }
}
