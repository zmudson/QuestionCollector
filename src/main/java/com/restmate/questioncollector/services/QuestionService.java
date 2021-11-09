package com.restmate.questioncollector.services;

import com.restmate.questioncollector.commands.QuestionCommand;
import com.restmate.questioncollector.converter.QuestionCommandToQuestion;
import com.restmate.questioncollector.converter.QuestionToQuestionCommand;
import com.restmate.questioncollector.domain.Category;
import com.restmate.questioncollector.domain.Question;
import com.restmate.questioncollector.repositories.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class QuestionService implements CrudService<Question, Long> {
    private final QuestionRepository questionRepository;
    private final QuestionCommandToQuestion questionCommandToQuestion;
    private final QuestionToQuestionCommand questionToQuestionCommand;

    public QuestionService(QuestionRepository questionRepository, QuestionCommandToQuestion questionCommandToQuestion, QuestionToQuestionCommand questionToQuestionCommand) {
        this.questionRepository = questionRepository;
        this.questionCommandToQuestion = questionCommandToQuestion;
        this.questionToQuestionCommand = questionToQuestionCommand;
    }

    @Override
    public Set<Question> findAll() {
        Set<Question> questions = new HashSet<>();
        questionRepository.findAll().iterator().forEachRemaining(questions::add);
        return questions;
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(Category.class, "Question with id " + id + " not found.")
        );
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    public QuestionCommand saveQuestionCommand(QuestionCommand command) {
        Question detachedQuestion = questionCommandToQuestion.convert(command);

        detachedQuestion.getCourse().addQuestion(detachedQuestion);

        Question savedQuestion = questionRepository.save(detachedQuestion);
        log.debug("Saved questionId: "+savedQuestion.getId());
        return questionToQuestionCommand.convert(savedQuestion);
    }
}
