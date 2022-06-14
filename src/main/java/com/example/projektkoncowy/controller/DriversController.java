package com.example.projektkoncowy.controller;


import com.example.projektkoncowy.model.Cars;
import com.example.projektkoncowy.model.Drivers;
import com.example.projektkoncowy.repository.CarRepository;
import com.example.projektkoncowy.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/drivers")
public class DriversController {


    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    CarRepository carRepository;


    @RequestMapping("/all")
    public String showDrivers(Model model){
        model.addAttribute("driver",driverRepository.findAll());
        return "drivers/all";
    }

    @GetMapping("/add")
    public String addDriver(Model model){
        model.addAttribute("driver",new Drivers());
        return "drivers/addDriver";
    }

    @PostMapping("/add")
    public String saveDriver(Drivers driver){
        driverRepository.save(driver);
        return "redirect:/drivers/all";
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String showById(@PathVariable Long id){
        Optional<Drivers> driver = driverRepository.findById(id);
        return driver.toString();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditDriverForm(@PathVariable Long id, Model model){
        model.addAttribute("driver",driverRepository.findById(id));
        return "drivers/edit";
    }
    @PostMapping("/edit")
    public String editDriver(@Valid Drivers driver, BindingResult result){
        if(result.hasErrors()){
            return "drivers/edit";
        }
        driverRepository.save(driver);
        return "redirect:/drivers/all";
    }

    @GetMapping("delete/{id}")
    public String deleteDriver(@PathVariable Long id){
        driverRepository.deleteById(id);
        return "redirect:/drivers/all";
    }


}
