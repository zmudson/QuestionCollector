package com.restmate.questioncollector.converter;

import com.restmate.questioncollector.commands.CourseCommand;
import com.restmate.questioncollector.domain.Course;
import org.springframework.core.convert.converter.Converter;

public class CourseCommandToCourse implements Converter<CourseCommand, Course> {
    @Override
    public Course convert(CourseCommand source) {
        if(source==null) return null;

        final Course course = new Course();
        course.setId(source.getId());
        course.setName(source.getName());

        return course;
    }
}
