package com.restmate.questioncollector.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sections")
public class Section extends BaseEntity{

    private SectionType sectionType;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "section"
    )
    private final Set<Course> courses = new HashSet<>();

    public Section(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public Section() {
    }

    public SectionType getSectionType() {
        return sectionType;
    }

    public void setSectionType(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}
