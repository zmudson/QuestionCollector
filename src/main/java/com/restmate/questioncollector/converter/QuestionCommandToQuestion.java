package com.restmate.questioncollector.converter;

import com.restmate.questioncollector.commands.QuestionCommand;
import com.restmate.questioncollector.domain.Question;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class QuestionCommandToQuestion implements Converter<QuestionCommand, Question> {

    @Synchronized
    @Nullable
    @Override
    public Question convert(QuestionCommand source) {
        if(source == null) return null; // theoretically always false but it is not

        final Question question = new Question();

        question.setId(source.getId());
        question.setDescription(source.getDescription());
        question.setAnswer(source.getAnswer());
        //TODO add all fields

        return question;
    }
}
