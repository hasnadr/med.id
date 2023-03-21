package com.xa.landingpage.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class LandingPageController {
    
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/landingpage/index");
        return view;
    }

    @GetMapping("/home")
    public ModelAndView home(HttpSession sess) {
        ModelAndView view = new ModelAndView("/home"); //file html
        return view;
    }

    @GetMapping("/index")
    public ModelAndView index(HttpSession sess) {
        ModelAndView view = new ModelAndView("/index"); //file html
        return view;
    }

}
