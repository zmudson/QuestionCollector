package com.restmate.questioncollector.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SubmitController {

    @RequestMapping({"/submit","/submit.html"})
    public String index(){
        return "submit";
    }
}
