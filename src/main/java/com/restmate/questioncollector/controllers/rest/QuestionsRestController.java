package com.restmate.questioncollector.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restmate.questioncollector.domain.SectionType;
import com.restmate.questioncollector.services.QuestionService;
import com.restmate.questioncollector.tools.SectionManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RestController
public class QuestionsRestController {
    private final QuestionService questionService;

    public QuestionsRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/api/questions")
    public String getQuestions(HttpServletRequest request) throws JsonProcessingException {
        String section = request.getParameter("section").toLowerCase(Locale.ROOT);
        SectionType sectionType = SectionManager.getSection(section);

        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(questionService.findAllBySectionJSON(sectionType));
    }
}
