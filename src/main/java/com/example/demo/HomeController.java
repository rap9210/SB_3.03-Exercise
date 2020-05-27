package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    TdlRepository tdlRepository;

    @RequestMapping("/")
    public String loadTDL(Model model){
        model.addAttribute("tdl", tdlRepository.findAll());
        return "toDoList";
    }

    @GetMapping("/add")
    public String addTask(Model model){
        model.addAttribute("tdl", new Tdl());
        return "addTask";
    }

    @PostMapping("/process")
    public String processTask(@Valid@ModelAttribute Tdl tdl, BindingResult result){
        if(result.hasErrors()){
            return "addTask";
        }
        else{
            tdlRepository.save(tdl);
            return "redirect:/";
        }
    }

    @RequestMapping("/update/{id}")
    public String updateTask(@PathVariable("id") long id, Model model){
        model.addAttribute("tdl", tdlRepository.findById(id).get());
        return "addTask";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") long id){
        tdlRepository.deleteById(id);
        return "redirect:/";
    }




}
