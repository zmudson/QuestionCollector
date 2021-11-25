package com.restmate.questioncollector.converter;

import com.restmate.questioncollector.commands.QuestionCommand;
import com.restmate.questioncollector.domain.Category;
import com.restmate.questioncollector.domain.Course;
import com.restmate.questioncollector.domain.Question;
import com.restmate.questioncollector.services.CategoryService;
import com.restmate.questioncollector.services.CourseService;
import com.restmate.questioncollector.services.CrudService;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class QuestionCommandToQuestion implements Converter<QuestionCommand, Question> {

    private final CrudService categoryService;
    private final CrudService courseService;

    public QuestionCommandToQuestion(CrudService categoryService, CrudService courseService) {
        this.categoryService = categoryService;
        this.courseService = courseService;
    }


    @Synchronized
    @Nullable
    @Override
    public Question convert(QuestionCommand source) {
        if(source == null) return null; // theoretically always false but it is not

        final Question question = new Question();

        question.setDescription(source.getDescription());
        question.setAnswer(source.getAnswer());

        Category category = ((CategoryService)categoryService).findById(Long.valueOf(source.getCategory()));
        Course course = ((CourseService)courseService).findById(Long.valueOf(source.getCourse()));
        course.addQuestion(question);
        category.addQuestion(question);

        question.setCategory(category);
        question.setCourse(course);

        return question;
    }
}
