package com.xa.landingpage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/home")
public class LandingPageController {
    
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("/home"); //file html
        return view;
    }

    @GetMapping("/user")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/index"); //file html
        return view;
    }

    @GetMapping("/user/{role_id}")
    public ModelAndView index(
        @PathVariable("role_id") Long roleId
    ) {
        ModelAndView view = new ModelAndView("/index"); //file html
        return view;
    }

}
