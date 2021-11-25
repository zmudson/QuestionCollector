package com.restmate.questioncollector.services;

import com.restmate.questioncollector.commands.QuestionCommand;
import com.restmate.questioncollector.converter.QuestionCommandToQuestion;
import com.restmate.questioncollector.converter.QuestionToQuestionCommand;
import com.restmate.questioncollector.converter.json.QuestionToQuestionJSON;
import com.restmate.questioncollector.domain.*;
import com.restmate.questioncollector.domain.json.QuestionJSON;
import com.restmate.questioncollector.repositories.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>();
        questionRepository.findAll().iterator().forEachRemaining(questions::add);
        return questions;
    }

    public List<Question> findAllBySection(SectionType sectionType){
        List<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(question -> {
            Course course = question.getCourse();
            Section section = course != null ? course.getSection() : null;
            if(section != null && section.getSectionType() == sectionType){
                questions.add(question);
            }
        });
        return questions;
    }

    public List<QuestionJSON> findAllBySectionJSON(SectionType sectionType){
        List<QuestionJSON> questions = new ArrayList<>();
        findAllBySection(sectionType).forEach(question -> {
            QuestionJSON questionJSON = QuestionToQuestionJSON.convert(question);
            questions.add(questionJSON);
        });
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

        Question savedQuestion = questionRepository.save(detachedQuestion);
        log.debug("Saved questionId: "+savedQuestion.getId());
        return questionToQuestionCommand.convert(savedQuestion);
    }
}
