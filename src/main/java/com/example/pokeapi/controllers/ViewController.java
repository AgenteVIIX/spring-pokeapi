package com.example.pokeapi.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ViewController {
    @RequestMapping("/pagina")
    public ModelAndView showAll() {
        System.out.println("asdasdasd");
        ModelAndView mav = new ModelAndView("index.html");
        return mav;
    }
}
