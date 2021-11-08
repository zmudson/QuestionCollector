package com.restmate.questioncollector.controllers;

import com.restmate.questioncollector.services.CrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SubmitController {
    private final CrudService categoryService;
    private final CrudService questionService;

    public SubmitController(
            @Qualifier("questionService") CrudService questionService,
            @Qualifier("categoryService") CrudService categoryService
    ) {
        this.categoryService = categoryService;
        this.questionService = questionService;
    }

    @RequestMapping({"/submit","/submit.html"})
    public String index(){
        return "submit";
    }
}
