package com.example.belong_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/***
 * Welcome controller
 */
@Controller
public class WelcomeController {

    /***
     * This is used to access the application. This is the first page of the app
     * @return
     */
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        return model;
    }
}