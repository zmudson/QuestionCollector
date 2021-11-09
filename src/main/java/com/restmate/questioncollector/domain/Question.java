package com.restmate.questioncollector.domain;

import javax.persistence.*;

@Entity
@Table(name = "questions")
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

    public Question() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
