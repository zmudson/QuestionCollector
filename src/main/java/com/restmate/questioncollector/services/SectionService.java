package com.restmate.questioncollector.services;

import com.restmate.questioncollector.domain.Section;
import com.restmate.questioncollector.domain.SectionType;
import com.restmate.questioncollector.repositories.SectionRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SectionService implements CrudService<Section, Long> {

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Set<Section> findAll() {
        Set<Section> sections = new HashSet<>();
        sectionRepository.findAll().iterator().forEachRemaining(sections::add);
        return sections;
    }

    @Override
    public Section findById(Long id) {
        return sectionRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(Section.class, "Section with id " + id + " not found.")
        );
    }

    public Section findBySectionType(SectionType sectionType){
        return sectionRepository.findBySectionType(sectionType).orElseThrow(
                () -> new ObjectNotFoundException(Section.class, "Section with type " + sectionType.name() + " not found.")
        );
    }

    @Override
    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public void delete(Section section) {
        sectionRepository.delete(section);
    }

    @Override
    public void deleteById(Long id) {
        sectionRepository.deleteById(id);
    }
}
