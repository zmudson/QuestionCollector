package com.restmate.questioncollector.bootstrap;

import com.restmate.questioncollector.domain.Course;
import com.restmate.questioncollector.domain.Section;
import com.restmate.questioncollector.domain.SectionType;
import com.restmate.questioncollector.services.CourseService;
import com.restmate.questioncollector.services.CrudService;
import com.restmate.questioncollector.services.SectionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CrudService courseService;
    private final CrudService sectionService;

    public Bootstrap(CrudService courseService, CrudService sectionService) {
        this.courseService = courseService;
        this.sectionService = sectionService;
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



    }
}
