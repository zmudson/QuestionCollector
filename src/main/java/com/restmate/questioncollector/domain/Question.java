package com.restmate.questioncollector.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Lob
    private String description;

    @Column(name = "answer")
    @Lob
    private String answer;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnoreProperties("questions")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("questions")
    private Category category;

    public Question(String description, String answer, Course course, Category category) {
        this.description = description;
        this.answer = answer;
        this.course = course;
        this.category = category;
    }

}
