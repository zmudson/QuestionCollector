package com.restmate.questioncollector.converter;

import com.restmate.questioncollector.commands.QuestionCommand;
import com.restmate.questioncollector.domain.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionCommandToQuestionTest {

    /*public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    public static final String ANSWER = "answer";

    QuestionCommandToQuestion converter;

    @BeforeEach
    void setUp() {
        converter = new QuestionCommandToQuestion();
    }

    @Test
    void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new QuestionCommand()));
    }

    @Test
    void convert() {
        QuestionCommand questionCommand = new QuestionCommand();

        questionCommand.setId(ID_VALUE);
        questionCommand.setDescription(DESCRIPTION);
        questionCommand.setAnswer(ANSWER);

        Question question = converter.convert(questionCommand);

        assertEquals(ID_VALUE, question.getId());
        assertEquals(DESCRIPTION, question.getDescription());
        assertEquals(ANSWER, question.getAnswer());

    }*/
}