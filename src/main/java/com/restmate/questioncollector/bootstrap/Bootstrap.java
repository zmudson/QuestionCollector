package com.restmate.questioncollector.bootstrap;

import com.restmate.questioncollector.domain.*;
import com.restmate.questioncollector.domain.Course;
import com.restmate.questioncollector.domain.Section;
import com.restmate.questioncollector.domain.SectionType;
import com.restmate.questioncollector.services.CrudService;
import com.restmate.questioncollector.services.SectionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Profile({"default", "bootstrap"})
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
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap class is working");

        Section frontend = new Section();
        frontend.setSectionType(SectionType.FRONTEND);

        Section backend = new Section();
        backend.setSectionType(SectionType.BACKEND);

        Course courseHTMLCSS = new Course();
        courseHTMLCSS.setName("Build Responsive Real-World Websites with HTML and CSS");
        Course courseAngular = new Course();
        courseAngular.setName("Angular - The Complete Guide (2022 Edition)");
        Course courseTypeScript = new Course();
        courseTypeScript.setName("Understanding TypeScript - 2022 Edition");

        Course courseSpringFrameworkGuru = new Course();
        courseSpringFrameworkGuru.setName("Spring Framework Guru");


        frontend.addCourse(courseHTMLCSS);
        frontend.addCourse(courseAngular);
        frontend.addCourse(courseTypeScript);

        backend.addCourse(courseSpringFrameworkGuru);

        ((SectionService)sectionService).save(frontend);
        ((SectionService)sectionService).save(backend);

        courseHTMLCSS.setSection(frontend);
        courseAngular.setSection(frontend);
        courseTypeScript.setSection(frontend);
        courseSpringFrameworkGuru.setSection(backend);

        courseService.save(courseHTMLCSS);
        courseService.save(courseAngular);
        courseService.save(courseTypeScript);
        courseService.save(courseSpringFrameworkGuru);

        //frontend categories
        Category categoryHTMLFundamentals = new Category();
        categoryHTMLFundamentals.setName("HTML Fundamentals");
        Category categoryCSSPos = new Category();
        categoryCSSPos.setName("CSS Positioning");
        Category categoryCSSffg = new Category();
        categoryCSSffg.setName("CSS floats, flexbox and grid");
        Category categoryCSSas  = new Category();
        categoryCSSas.setName("CSS animations, shadows");
        Category categoryWDR  = new Category();
        categoryWDR.setName("Web design rules");
        Category categoryCaLP  = new Category();
        categoryCaLP.setName("Components and layout patterns");
        Category categoryRWD  = new Category();
        categoryRWD.setName("Responsive web design");
        Category categoryWO  = new Category();
        categoryWO.setName("Webpage optimization");

        Category categoryTSBaT  = new Category();
        categoryTSBaT.setName("Typescript basics and types");
        Category categoryCompiler  = new Category();
        categoryCompiler.setName("Compiler");
        Category categoryCaI  = new Category();
        categoryCaI.setName("Classes and interfaces");
        Category categoryATGD  = new Category();
        categoryATGD.setName("Advanced types, generics, decorators");
        Category categoryMaN  = new Category();
        categoryMaN.setName("Modules and namespaces");
        Category categoryWebpack  = new Category();
        categoryWebpack.setName("Webpack");
        Category category3PL  = new Category();
        category3PL.setName("3rd Party libraries");

        Category categoryCaD  = new Category();
        categoryCaD.setName("Components and databinding");
        Category categoryDSaDI  = new Category();
        categoryDSaDI.setName("Directives, services and dependency injection");
        Category categoryRaO  = new Category();
        categoryRaO.setName("Routing and observables");
        Category categoryForms  = new Category();
        categoryForms.setName("Forms");
        Category categoryHR  = new Category();
        categoryHR.setName("Http requests");
        Category categoryAaRP  = new Category();
        categoryAaRP.setName("Authentication and route projection");
        Category categoryModules  = new Category();
        categoryModules.setName("Modules");
        Category categoryNgRx  = new Category();
        categoryNgRx.setName("NgRx");






        //backend categories
        Category categoryDependencyInjection = new Category();
        categoryDependencyInjection.setName("Dependency Injection");
        Category categoryJpa = new Category();
        categoryJpa.setName("Spring Data JPA");
        Category categoryMaven = new Category();
        categoryMaven.setName("Maven");
        Category categoryHibernate = new Category();
        categoryHibernate.setName("Hibernate");
        Category categoryMySQL = new Category();
        categoryMySQL.setName("MySQL");
        Category categoryMVC = new Category();
        categoryMVC.setName("Thymeleaf MVC");
        Category categoryDocker = new Category();
        categoryDocker.setName("Docker");
        Category categoryREST = new Category();
        categoryREST.setName("REST");

        categoryService.save(categoryHTMLFundamentals);
        categoryService.save(categoryCSSPos);
        categoryService.save(categoryCSSffg);
        categoryService.save(categoryCSSas);
        categoryService.save(categoryWO);
        categoryService.save(categoryWDR);
        categoryService.save(categoryWO);
        categoryService.save(categoryRWD);

        categoryService.save(categoryTSBaT);
        categoryService.save(categoryCompiler);
        categoryService.save(categoryCaI);
        categoryService.save(categoryATGD);
        categoryService.save(categoryMaN);
        categoryService.save(categoryWebpack);
        categoryService.save(category3PL);

        categoryService.save(categoryCaD);
        categoryService.save(categoryDSaDI);
        categoryService.save(categoryRaO);
        categoryService.save(categoryForms);
        categoryService.save(categoryHR);
        categoryService.save(categoryAaRP);
        categoryService.save(categoryModules);
        categoryService.save(categoryNgRx);


        categoryService.save(categoryDependencyInjection);
        categoryService.save(categoryJpa);
        categoryService.save(categoryMaven);
        categoryService.save(categoryHibernate);
        categoryService.save(categoryMySQL);
        categoryService.save(categoryMVC);
        categoryService.save(categoryDocker);
        categoryService.save(categoryREST);

        courseSpringFrameworkGuru.addCategory(categoryDependencyInjection);
        courseSpringFrameworkGuru.addCategory(categoryJpa);
        courseSpringFrameworkGuru.addCategory(categoryMaven);
        courseSpringFrameworkGuru.addCategory(categoryHibernate);
        courseSpringFrameworkGuru.addCategory(categoryMySQL);
        courseSpringFrameworkGuru.addCategory(categoryMVC);
        courseSpringFrameworkGuru.addCategory(categoryDocker);
        courseSpringFrameworkGuru.addCategory(categoryREST);

        courseHTMLCSS.addCategory(categoryHTMLFundamentals);
        courseHTMLCSS.addCategory(categoryCSSPos);
        courseHTMLCSS.addCategory(categoryCSSffg);
        courseHTMLCSS.addCategory(categoryCSSas);
        courseHTMLCSS.addCategory(categoryWDR);
        courseHTMLCSS.addCategory(categoryRWD);
        courseHTMLCSS.addCategory(categoryWO);

        courseTypeScript.addCategory(categoryTSBaT);
        courseTypeScript.addCategory(categoryCompiler);
        courseTypeScript.addCategory(categoryCaI);
        courseTypeScript.addCategory(categoryATGD);
        courseTypeScript.addCategory(categoryMaN);
        courseTypeScript.addCategory(categoryWebpack);
        courseTypeScript.addCategory(category3PL);

        courseAngular.addCategory(categoryCaD);
        courseAngular.addCategory(categoryDSaDI);
        courseAngular.addCategory(categoryRaO);
        courseAngular.addCategory(categoryForms);
        courseAngular.addCategory(categoryHR);
        courseAngular.addCategory(categoryAaRP);
        courseAngular.addCategory(categoryModules);
        courseAngular.addCategory(categoryNgRx);


        Question q1 = new Question();
        q1.setCategory(categoryMySQL);
        q1.setCourse(courseSpringFrameworkGuru);
        q1.setDescription("How get all elements from table Questions?");
        q1.setAnswer("SELECT * FROM Questions");



        questionService.save(q1);

    }
}
