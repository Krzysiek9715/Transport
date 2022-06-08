package com.example.projektkoncowy.controller;

import com.example.projektkoncowy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mainMenu")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String menu(){
        return "mainMenu";
    }
}
