package com.restmate.questioncollector.converter;

import com.restmate.questioncollector.commands.CourseCommand;
import com.restmate.questioncollector.domain.Course;
import org.springframework.core.convert.converter.Converter;

public class CourseToCourseCommand implements Converter<Course, CourseCommand> {
    @Override
    public CourseCommand convert(Course source) {
        if(source==null) return null;

        final CourseCommand courseCommand = new CourseCommand();
        courseCommand.setId(source.getId());
        courseCommand.setName(source.getName());

        return courseCommand;
    }
}
