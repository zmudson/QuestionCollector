package com.restmate.questioncollector.converter.json;

import com.restmate.questioncollector.domain.Category;
import com.restmate.questioncollector.domain.Course;
import com.restmate.questioncollector.domain.Question;
import com.restmate.questioncollector.domain.Section;
import com.restmate.questioncollector.domain.json.QuestionJSON;

import java.util.Locale;

public class QuestionToQuestionJSON {
    public static QuestionJSON convert(Question question){
        QuestionJSON questionJSON = new QuestionJSON();

        if(question != null){
            questionJSON.setDescription(question.getDescription());
            questionJSON.setAnswer(question.getAnswer());
            Category category = question.getCategory();
            questionJSON.setCategory(category != null ? category.getName() : null);
            Course course = question.getCourse();
            questionJSON.setCourse(course != null ? course.getName() : null);
            Section section = course != null ? course.getSection() : null;
            assert section != null;
            questionJSON.setSection(section.getSectionType().toString().toLowerCase(Locale.ROOT));
        }

        return questionJSON;
    }
}
