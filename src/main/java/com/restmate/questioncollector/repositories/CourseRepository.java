package com.restmate.questioncollector.repositories;

import com.restmate.questioncollector.domain.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<Course> findByName(String name);
}
