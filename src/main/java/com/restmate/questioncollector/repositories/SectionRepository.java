package com.restmate.questioncollector.repositories;

import com.restmate.questioncollector.domain.Section;
import com.restmate.questioncollector.domain.SectionType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SectionRepository extends CrudRepository<Section, Long> {
    Optional<Section> findBySectionType(SectionType sectionType);
}
