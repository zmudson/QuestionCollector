package com.restmate.questioncollector.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "sections")
public class Section extends BaseEntity{

    private SectionType sectionType;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "section"
    )
    @JsonIgnoreProperties("section")
    private final Set<Course> courses = new HashSet<>();

    public Section() {
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}
