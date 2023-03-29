package com.xa.landingpage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/customerrelation")
public class CustomerRelationController {
    
    @GetMapping("/index")
    public ModelAndView customerRelation() {
        ModelAndView view = new ModelAndView("/customerrelation/index");
        return view;
    }
}
