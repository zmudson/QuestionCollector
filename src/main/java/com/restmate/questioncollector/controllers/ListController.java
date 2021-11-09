package com.restmate.questioncollector.controllers;

import com.restmate.questioncollector.services.CrudService;
import com.restmate.questioncollector.services.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ListController {
    private final CrudService questionService;
    private final CrudService categoryService;
    private final CrudService sectionService;
    private final CrudService courseService;


    public ListController(
            @Qualifier("questionService") CrudService questionService,
            @Qualifier("categoryService") CrudService categoryService,
            @Qualifier("sectionService") CrudService sectionService,
            @Qualifier("courseService") CrudService courseService
    ) {
        this.questionService = questionService;
        this.categoryService = categoryService;
        this.sectionService = sectionService;
        this.courseService = courseService;
    }

    @RequestMapping({"/questions","/questions.html"})
    public String index(Model model){
        model.addAttribute("questions", ((QuestionService)questionService).findAll());
        return "list";
    }
}
