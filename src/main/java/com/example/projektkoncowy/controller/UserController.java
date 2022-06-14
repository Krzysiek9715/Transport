package com.example.projektkoncowy.controller;

import com.example.projektkoncowy.model.Drivers;
import com.example.projektkoncowy.model.User;
import com.example.projektkoncowy.repository.RoleRepository;
import com.example.projektkoncowy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @RequestMapping("/all")
    public String viewAllUsers(Model model){
        model.addAttribute("user",userRepository.findAll());
        return "/users/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditDriverForm(@PathVariable Long id, Model model){
        model.addAttribute("user",userRepository.findById(id));
        model.addAttribute("roles",roleRepository.findAll());
        return "users/edit";
    }
    @PostMapping("/edit")
    public String editDriver(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "users/edit";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/drivers/all";
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String showById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        return user.toString();
    }
}
