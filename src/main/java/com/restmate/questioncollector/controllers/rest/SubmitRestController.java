package com.restmate.questioncollector.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restmate.questioncollector.domain.Course;
import com.restmate.questioncollector.domain.SectionType;
import com.restmate.questioncollector.services.CategoryService;
import com.restmate.questioncollector.services.CourseService;
import com.restmate.questioncollector.tools.SectionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RestController
public class SubmitRestController {
    private final CourseService courseService;
    private final CategoryService categoryService;

    public SubmitRestController(CourseService courseService, CategoryService categoryService) {
        this.courseService = courseService;
        this.categoryService = categoryService;
    }

    @GetMapping("/api/submit/courses")
    public String getCourses(HttpServletRequest request) throws JsonProcessingException {
        String section = request.getParameter("section").toLowerCase(Locale.ROOT);
        SectionType sectionType = SectionManager.getSection(section);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(courseService.findAllBySection(sectionType));
    }

    @GetMapping("/api/submit/categories")
    public String getCategories(HttpServletRequest request) throws JsonProcessingException {
        Long courseId = Long.valueOf(request.getParameter("courseId"));
        ObjectMapper objectMapper = new ObjectMapper();
        Course course = courseService.findById(courseId);
        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(course.getCategories());
    }
}
