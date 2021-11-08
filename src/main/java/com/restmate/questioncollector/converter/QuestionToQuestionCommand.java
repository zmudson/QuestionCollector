package com.restmate.questioncollector.converter;

import com.restmate.questioncollector.commands.QuestionCommand;
import com.restmate.questioncollector.domain.Question;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class QuestionToQuestionCommand implements Converter<Question, QuestionCommand> {

    @Synchronized
    @Nullable
    @Override
    public QuestionCommand convert(Question source) {

        QuestionCommand questionCommand = new QuestionCommand();
        questionCommand.setId(source.getId());
        questionCommand.setDescription(source.getDescription());
        questionCommand.setAnswer(source.getAnswer());
        //questionCommand.setCourse(source.getCourse());
        //questionCommand.setCategory(source.getCategory());

        //TODO add all fields

        return questionCommand;
    }
}
