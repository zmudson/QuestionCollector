package com.restmate.questioncollector.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course extends BaseEntity  implements Comparable<Course>{

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "course"
    )
    private Set<Question> questions = new HashSet<>();

    public Course(String name, Section section) {
        this.name = name;
        this.section = section;
    }

    public Course() {
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.getName());
    }
}
