package com.springboot.springsecurity.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/account")
public class NoticeController {

    @GetMapping("/my-account")
    @PostAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAccountDetails(){
        System.out.println("Return");
        return "Get account details";
    }
}
