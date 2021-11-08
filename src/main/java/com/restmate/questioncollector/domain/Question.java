package com.restmate.questioncollector.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@Getter
@Setter
public class Question extends BaseEntity{

    @Column(name = "description")
    private String description;

    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Question(String description, String answer, Course course, Category category) {
        this.description = description;
        this.answer = answer;
        this.course = course;
        this.category = category;
    }

}
