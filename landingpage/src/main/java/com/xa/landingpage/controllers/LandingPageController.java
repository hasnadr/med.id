package com.xa.landingpage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/main")
public class LandingPageController {
    
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("/home"); //file html
        return view;
    }

    @GetMapping("/home/user")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/index"); //file html
        return view;
    }

}
