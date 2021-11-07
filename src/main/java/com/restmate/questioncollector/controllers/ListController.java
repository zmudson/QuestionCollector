package com.restmate.questioncollector.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ListController {

    @RequestMapping({"/questions","/questions.html"})
public String index(){

    return "list";
}
}
