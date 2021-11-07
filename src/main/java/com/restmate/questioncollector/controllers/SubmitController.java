package com.restmate.questioncollector.controllers;

import com.restmate.questioncollector.services.CrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import com.restmate.questioncollector.commands.QuestionCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String index(Model model){
        model.addAttribute("question", new QuestionCommand());

        return "submit";
    }

    @PostMapping("/submit/add/")
    public String addNewQuestion(@ModelAttribute QuestionCommand questionCommand) {

        //TODO save to service
        System.out.println(questionCommand);
        return "redirect:/";
    }
}
