package com.restmate.questioncollector.repositories;

import com.restmate.questioncollector.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
