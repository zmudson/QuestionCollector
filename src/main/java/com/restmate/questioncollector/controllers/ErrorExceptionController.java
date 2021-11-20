package com.restmate.questioncollector.controllers;

import com.restmate.questioncollector.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice
public class ErrorExceptionController implements ErrorController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class, NumberFormatException.class})
    public ModelAndView notFound(Exception exception) {
        log.error(exception.getMessage());
        ModelAndView mav = new ModelAndView();
        int errorId = 444;
        if(exception instanceof NumberFormatException) errorId = 400;
        if(exception instanceof NotFoundException) errorId = 404;

        mav.addObject("nr", errorId);
        mav.addObject("message", exception.getMessage());
        mav.setViewName("error_page");

        return mav;
    }


}
