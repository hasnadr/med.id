package com.xa.miniproject313_fe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class LandingPageController {

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("/home"); // file html
        return view;
    }

    @GetMapping("/homeadmin")
    public ModelAndView admin() {
        ModelAndView view = new ModelAndView("/homeadmin"); // file html
        return view;
    }

    @GetMapping("/bank")
    public ModelAndView menuBank() {
        ModelAndView view = new ModelAndView("bank/index"); // file html
        return view;
    }
}
