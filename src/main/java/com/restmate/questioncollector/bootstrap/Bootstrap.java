package com.restmate.questioncollector.bootstrap;

import com.restmate.questioncollector.domain.*;
import com.restmate.questioncollector.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CrudService courseService;
    private final CrudService sectionService;
    private final CrudService categoryService;
    private final CrudService questionService;

    public Bootstrap(CrudService courseService, CrudService sectionService, CrudService categoryService, CrudService questionService) {
        this.courseService = courseService;
        this.sectionService = sectionService;
        this.categoryService = categoryService;
        this.questionService = questionService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap class is working");

        Section frontend = new Section();
        frontend.setSectionType(SectionType.FRONTEND);

        Section backend = new Section();
        backend.setSectionType(SectionType.BACKEND);

        Course course1 = new Course();
        course1.setName("HTML & CSS");
        Course course2 = new Course();
        course2.setName("Angular");
        Course course3 = new Course();
        course3.setName("Typescript");

        Course course4 = new Course();
        course4.setName("Spring Framework Guru");

        Course course5 = new Course();
        course5.setName("Spring Boot Microservices");

        frontend.addCourse(course1);
        frontend.addCourse(course2);
        frontend.addCourse(course3);

        backend.addCourse(course4);
        backend.addCourse(course5);

        ((SectionService)sectionService).save(frontend);
        ((SectionService)sectionService).save(backend);

        course1.setSection(frontend);
        course2.setSection(frontend);
        course3.setSection(frontend);
        course4.setSection(backend);
        course5.setSection(backend);

        ((CourseService)courseService).save(course1);
        ((CourseService)courseService).save(course2);
        ((CourseService)courseService).save(course3);
        ((CourseService)courseService).save(course4);
        ((CourseService)courseService).save(course5);

        Category category1 = new Category();
        category1.setName("CSS - positioning");
        Category category2 = new Category();
        category2.setName("JavaScript - OOP");
        Category category4 = new Category();
        category4.setName("Dependency Injection");
        Category category3 = new Category();
        category3.setName("Spring Data JPA");

        ((CategoryService)categoryService).save(category1);
        ((CategoryService)categoryService).save(category2);
        ((CategoryService)categoryService).save(category3);
        ((CategoryService)categoryService).save(category4);

        Question q1 = new Question();
        q1.setCategory(category1);
        q1.setCourse(course1);
        q1.setDescription("How to center a div");
        q1.setAnswer("use your brain");

        Question q2 = new Question();
        q2.setCategory(category4);
        q2.setCourse(course4);
        q2.setDescription("What is spring context");
        q2.setAnswer("idk");

        ((QuestionService)questionService).save(q1);
        ((QuestionService)questionService).save(q2);
    }
}
