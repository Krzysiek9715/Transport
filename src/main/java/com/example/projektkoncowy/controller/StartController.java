package com.example.projektkoncowy.controller;


import com.example.projektkoncowy.model.Drivers;
import com.example.projektkoncowy.model.User;
import com.example.projektkoncowy.repository.DriverRepository;
import com.example.projektkoncowy.repository.RoleRepository;
import com.example.projektkoncowy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @RequestMapping("/")
    public String mainPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userRepository.findByUsername(name);
        if (user.getRole().getName().equals("DRIVER")){
            model.addAttribute("user",user);
            model.addAttribute("driver",user.getDrivers());
            return "driverDashboard";
        }
        return "dashboard";
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles",roleRepository.findAll());
        return "/users/register";
    }

    @PostMapping("/register")
    public String register(User user){
        if (user.getRole().getName().equals("DRIVER")){
            return "redirect:/drivers/add";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/users/all";
    }


}
