package com.xa.landingpage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/profile")
public class ProfileController {
    
    @GetMapping("/index")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("/profile/index"); //file html
        return view;
    }

}
