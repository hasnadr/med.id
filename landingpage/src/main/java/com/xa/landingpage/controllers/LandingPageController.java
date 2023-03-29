package com.xa.landingpage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/home")
public class LandingPageController {
    
    @GetMapping("/public")
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

    // @GetMapping("/user/{role_id}/{parent_id}")
    // public ModelAndView akses(
    //     @PathVariable("role_id") Long roleId,
    //     @PathVariable("parent_id") Long parentId
    // ) {
    //     ModelAndView akses = new ModelAndView("/akses/index"); //file html
    //     return akses;
    // }

    @GetMapping("/search-doctor")
    public ModelAndView searchDoctor() {
        ModelAndView view = new ModelAndView("/search-doctor"); //file html
        return view;
    }

    // @GetMapping("/search-doctor/{spId}")
    // public ModelAndView searchDoctorById(
    //     @PathVariable("spId") Long spId
    // ) {
    //     ModelAndView view = new ModelAndView("/search-doctor"); //file html
    //     return view;
    // }

    // @GetMapping("/search-doctor/{lokasiId}/{namaDokter}/{spId}/{tindakanId}")
    // public ModelAndView searchDoctorById(
    //     @PathVariable("lokasiId") Long lokasiId,
    //     @PathVariable("namaDokter") String dokter,
    //     @PathVariable("spId") Long spId,
    //     @PathVariable("tindakanId") Long tindakanId
    // ) {
    //     ModelAndView view = new ModelAndView("/search-doctor"); //file html
    //     return view;
    // }

    @GetMapping("/search-doctor/{lokasi}/{dokter}/{sp}/{tindakan}")
    public ModelAndView searchDoctorById(
        @PathVariable("lokasi") String lokasi,
        @PathVariable("dokter") String dokter,
        @PathVariable("sp") String sp,
        @PathVariable("tindakan") String tindakan
    ) {
        ModelAndView view = new ModelAndView("/search-doctor"); //file html
        return view;
    }

    @GetMapping("/customer-relation")
    public ModelAndView customerSearch() {
        ModelAndView view = new ModelAndView("/customer-relation");
        return view;
    }

}
