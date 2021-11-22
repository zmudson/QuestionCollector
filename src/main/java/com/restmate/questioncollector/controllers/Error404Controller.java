package com.restmate.questioncollector.controllers;

import com.restmate.questioncollector.exceptions.NotFoundException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class Error404Controller implements ErrorController {

    @RequestMapping("/error")
    public String pageNotFound() {
        throw new NotFoundException("User got 404 error");
//        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "tset");
    }

}
