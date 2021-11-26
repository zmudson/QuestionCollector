package com.restmate.questioncollector.controllers;

import com.restmate.questioncollector.exceptions.NotFoundException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Error404Controller implements ErrorController {

    @RequestMapping("/error")
    public String pageNotFound() {
        throw new NotFoundException("User got 404 error");
    }

    @RequestMapping("/bad_request")
    public String badRequest(Model model) {
        model.addAttribute("nr", HttpStatus.BAD_REQUEST.value());
        model.addAttribute("message", "Bad request.");
        return("error_page");
    }

}
