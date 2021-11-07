package com.restmate.questioncollector.controllers;

import com.restmate.questioncollector.commands.QuestionCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SubmitController {

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
