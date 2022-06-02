package com.example.projektkoncowy.controller;

import com.example.projektkoncowy.model.Cars;
import com.example.projektkoncowy.model.Drivers;
import com.example.projektkoncowy.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping("/all")
    public String showDrivers(Model model){
        model.addAttribute("car",carRepository.findAll());
        return "cars/all";
    }

    @GetMapping("/add")
    public String addDriver(Model model){
        model.addAttribute("car",new Cars());
        return "cars/add";
    }

    @PostMapping("/add")
    public String saveDriver(Cars car){
        carRepository.save(car);
        return "redirect:/cars/all";
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String showById(@PathVariable Long id){
        Optional<Cars> car = carRepository.findById(id);
        return car.toString();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditCarForm(@PathVariable Long id, Model model){
        model.addAttribute("car",carRepository.findById(id));
        return "cars/edit";
    }
    @PostMapping("/edit")
    public String editCar(@Valid Cars car, BindingResult result){
        if(result.hasErrors()){
            return "cars/edit";
        }
        carRepository.save(car);
        return "redirect:/cars/all";
    }

    @GetMapping("delete/{id}")
    public String deleteCar(@PathVariable Long id){
        carRepository.deleteById(id);
        return "redirect:/cars/all";
    }
}
