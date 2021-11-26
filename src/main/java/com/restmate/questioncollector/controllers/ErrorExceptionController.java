package com.restmate.questioncollector.controllers;

import com.restmate.questioncollector.exceptions.BadRequestException;
import com.restmate.questioncollector.exceptions.ErrorObject;
import com.restmate.questioncollector.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice
public class ErrorExceptionController implements ErrorController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView notFound(Exception exception) {
        log.error(exception.getMessage());
        ModelAndView mav = new ModelAndView();

        mav.addObject("nr", HttpStatus.NOT_FOUND.value());
        mav.addObject("message", "This page does not exist.");
        mav.setViewName("error_page");

        return mav;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NumberFormatException.class, BadRequestException.class, ObjectNotFoundException.class})
    public String badRequest(Exception exception) {
        log.error(exception.getMessage());
        return "redirect:/bad_request";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResponseStatusException.class)
    public @ResponseBody ErrorObject jsonError(Exception exception) {
        log.error(exception.getMessage());
        return new ErrorObject("Bad request", HttpStatus.BAD_REQUEST.value());
    }


}
