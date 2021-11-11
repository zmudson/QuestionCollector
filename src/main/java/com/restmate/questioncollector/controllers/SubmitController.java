package com.restmate.questioncollector.controllers;

import com.restmate.questioncollector.domain.Category;
import com.restmate.questioncollector.domain.Course;
import com.restmate.questioncollector.services.CategoryService;
import com.restmate.questioncollector.services.CourseService;
import com.restmate.questioncollector.services.CrudService;
import com.restmate.questioncollector.services.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import com.restmate.questioncollector.commands.QuestionCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
import java.util.TreeSet;

@Slf4j
@Controller
public class SubmitController {
    private final CrudService categoryService;
    private final CrudService questionService;
    private final CrudService courseService;

    public SubmitController(
            CrudService categoryService, @Qualifier("questionService") CrudService questionService,
            @Qualifier("courseService") CrudService courseService) {
        this.categoryService = categoryService;
        //this.categoryService = categoryService;
        this.questionService = questionService;
        this.courseService = courseService;
    }

    @RequestMapping({"/submit","/submit.html"})
    public String index(Model model){

        TreeSet<Course> courses = new TreeSet<>(((CourseService) courseService).findAll());
        TreeSet<Category> categories = new TreeSet<>(((CategoryService)categoryService).findAll());

        model.addAttribute("question", new QuestionCommand());
        model.addAttribute("courses", courses);
        model.addAttribute("categories", categories);

        return "submit";
    }

    @PostMapping("/submit/add/")
    public String addNewQuestion(@ModelAttribute QuestionCommand questionCommand) {

        if(!questionCommand.isNotNull()) return "redirect:/submit";

        log.debug(String.valueOf(questionCommand));

        QuestionCommand savedCommand = ((QuestionService) questionService).saveQuestionCommand(questionCommand);
        return "redirect:/";
    }
}
