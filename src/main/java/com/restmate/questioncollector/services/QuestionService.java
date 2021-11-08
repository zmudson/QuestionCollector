package com.restmate.questioncollector.services;

import com.restmate.questioncollector.domain.Category;
import com.restmate.questioncollector.domain.Question;
import com.restmate.questioncollector.repositories.QuestionRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionService implements CrudService<Question, Long> {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
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
}
