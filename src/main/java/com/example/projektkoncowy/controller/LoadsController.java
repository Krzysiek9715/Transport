package com.example.projektkoncowy.controller;


import com.example.projektkoncowy.model.LoadImport;
import com.example.projektkoncowy.model.Loads;
import com.example.projektkoncowy.repository.LoadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/loads")
public class LoadsController {

    @Autowired
    private LoadsRepository loadsRepository;


    @RequestMapping("/all")
    public String showLoads(Model model){
        model.addAttribute(
                "load",loadsRepository.findAll());
        return "loads/all";
    }

    @GetMapping("/add")
    public String addLoad(Model model){
        model.addAttribute("load",new Loads());
        return "loads/add";
    }

    @PostMapping("/add")
    public String saveLoad(Loads loads){
        loadsRepository.save(loads);
        return "redirect:/loads/all";
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String showById(@PathVariable Long id){
        Optional<Loads> load = loadsRepository.findById(id);
        return load.toString();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditDriverForm(@PathVariable Long id, Model model){
        model.addAttribute("load",loadsRepository.findById(id));
        return "loads/edit";
    }
    @PostMapping("/edit")
    public String editDriver(@Valid Loads loads, BindingResult result){
        if(result.hasErrors()){
            return "loads/edit";
        }
        loadsRepository.save(loads);
        return "redirect:/loads/all";
    }

    @GetMapping("delete/{id}")
    public String deleteDriver(@PathVariable Long id){
        loadsRepository.deleteById(id);
        return "redirect:/loads/all";
    }

    @RequestMapping("/price/{id}")
    public String countPriceForKm(@PathVariable Long id, Model model){
        Integer sumPrice, sumKilometers;
        Float euroForKm;
        Loads export = loadsRepository.findLoadsById(id);
        if(export.getLoadImport() == LoadImport.WITH_IMPORT){
            model.addAttribute("export",export);
            Loads importLoad = loadsRepository.findLoadsById(export.getImportLoads().getId());
            model.addAttribute("importLoad",importLoad);
            sumPrice=export.getPrice()+importLoad.getPrice();
            sumKilometers = export.getKilometers()+importLoad.getKilometers();
            euroForKm = (float)sumPrice/(float) sumKilometers;
            model.addAttribute("sumPrice",sumPrice);
            model.addAttribute("sumKilometers",sumKilometers);
            model.addAttribute("euroForKm",euroForKm);
            return "/loads/report/exportImport";
//            return export.toString()+"/////////"+importLoad.toString()+"////////"+sumKilometers+"////"+sumPrice+"//////"+euroForKm;
        }
        if(export.getLoadImport() == LoadImport.IMPORT){
            return "loads/errors/import";
        }
        euroForKm = (float)(export.getPrice())/(float)(export.getKilometers());
        model.addAttribute("export",export);
        model.addAttribute("euroForKm",euroForKm);
        return "loads/report/export";
//        return export.toString()+"//////////"+euroForKm;
       }



}
