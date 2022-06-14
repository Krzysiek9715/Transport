package com.example.projektkoncowy.controller;

import com.example.projektkoncowy.model.Drivers;
import com.example.projektkoncowy.model.Loads;
import com.example.projektkoncowy.model.User;
import com.example.projektkoncowy.repository.DriverRepository;
import com.example.projektkoncowy.repository.LoadsRepository;
import com.example.projektkoncowy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Driver;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/driverData")
public class DriverViewController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    LoadsRepository loadsRepository;

    @RequestMapping("/load/{id}")
    public String showDriverLoad(@PathVariable Long id, Model model){
        Integer kilometerSum = 0;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("driverLoads", loadsRepository.findLoadsByDriversId(id));
        List<Loads> loads = loadsRepository.findLoadsByDriversId(id);
        kilometerSum = loads.stream()
                .map(loads1 -> loads1.getKilometers())
                .reduce(0,Integer::sum);

        model.addAttribute("kilometerSum", kilometerSum);
        return "/loads/oneDriverLoad";
//            return loads.toString();
    }

    @RequestMapping("/car/{id}")
    public String showDriversCar(@PathVariable Long id, Model model){
        Drivers drivers = driverRepository.findDriversById(id);
        model.addAttribute("car",drivers.getCars());
        return "cars/oneDriverCar";
    }
}
